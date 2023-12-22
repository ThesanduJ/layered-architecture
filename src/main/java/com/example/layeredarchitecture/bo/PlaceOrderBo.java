package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo {
     boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
     ItemDTO findItem(String code);
     String searchCustomer(Object newValue) throws SQLException, ClassNotFoundException;

     ItemDTO searchItem(Object newValue) throws SQLException, ClassNotFoundException;

     boolean exitsItem(String code) throws SQLException, ClassNotFoundException;
     boolean exitsCustomer(String code) throws SQLException, ClassNotFoundException;
     String genarateOrderId() throws SQLException, ClassNotFoundException;

     ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
}
