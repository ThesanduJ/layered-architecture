package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<OrderDTO> {
    //    String genarateOrderId() throws SQLException, ClassNotFoundException;
//
//    boolean isExits(String orderId) throws SQLException, ClassNotFoundException;
//
    boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
