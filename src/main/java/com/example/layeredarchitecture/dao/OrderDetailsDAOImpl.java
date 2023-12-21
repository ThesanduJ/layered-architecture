package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsDAOImpl implements OrderDeailsDAO {
    @Override
    public boolean isSave(String orderId, OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", orderId, dto.getItemCode(), dto.getUnitPrice(), dto.getQty());

    }
}
