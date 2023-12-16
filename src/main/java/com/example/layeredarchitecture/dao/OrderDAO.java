package com.example.layeredarchitecture.dao;

import java.sql.SQLException;

public interface OrderDAO {
     String genarateOrderId() throws SQLException, ClassNotFoundException;

}
