package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDeailsDAO extends CrudDAO<OrderDetailDTO> {
    boolean isSave(String orderId, OrderDetailDTO dto) throws SQLException, ClassNotFoundException;

}
