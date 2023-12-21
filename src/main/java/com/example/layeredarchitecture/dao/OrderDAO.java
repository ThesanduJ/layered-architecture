package com.example.layeredarchitecture.dao;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    String genarateOrderId() throws SQLException, ClassNotFoundException;

    boolean isExits(String orderId) throws SQLException, ClassNotFoundException;

    boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;
}
