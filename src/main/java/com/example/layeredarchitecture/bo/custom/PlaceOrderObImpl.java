package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBo;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.dao.custom.OrderDeailsDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderObImpl implements PlaceOrderBo {
    ItemDAO itemDAO = new ItemDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDeailsDAO orderDeailsDAO = new OrderDetailsDAOImpl();

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = null;


            connection = DBConnection.getDbConnection().getConnection();
            boolean isExits = orderDAO.exits(orderId);

            if (isExits) {
                return false;
            }

            connection.setAutoCommit(false);
            boolean isSave = orderDAO.saveOrder(orderId, orderDate, customerId);

            if (!isSave) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            for (OrderDetailDTO detail : orderDetails) {
                boolean orderDeailsDAOSave = orderDeailsDAO.isSave(orderId, detail);

                if (!orderDeailsDAOSave) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());


                boolean itemSave = itemDAO.update(item);

                if (!itemSave) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }


                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }

        return false;
    }
    @Override
    public ItemDTO findItem(String code) {
        try {
            ItemDTO findItem = itemDAO.findItem(code);
            return findItem;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String searchCustomer(Object newValue) throws SQLException, ClassNotFoundException {
        return customerDAO.searchCustomer(newValue);
    }

    @Override
    public ItemDTO searchItem(Object newValue) throws SQLException, ClassNotFoundException {
        return itemDAO.searchItem(newValue);
    }

    @Override
    public boolean exitsItem(String code) throws SQLException, ClassNotFoundException {
        return  itemDAO.exits(code);
    }

    @Override
    public boolean exitsCustomer(String code) throws SQLException, ClassNotFoundException {
        return customerDAO.exits(code);
    }

    @Override
    public String genarateOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.genarateId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }


}
