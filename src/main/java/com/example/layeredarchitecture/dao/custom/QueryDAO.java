package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.PlaceOrderDTO;

import java.sql.SQLException;

public interface QueryDAO {
    PlaceOrderDTO printDeatils() throws SQLException, ClassNotFoundException;
}
