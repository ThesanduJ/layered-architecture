package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDeailsDAO {
    boolean isSave(String orderId,OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
