package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    boolean isDelete(String code) throws SQLException, ClassNotFoundException;

    boolean isAdd(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean isExits(String code) throws SQLException, ClassNotFoundException;

    String GenarateCode() throws SQLException, ClassNotFoundException;

    boolean isUpdate(String code, String description, int qtyOnHand, BigDecimal unitPrice) throws SQLException, ClassNotFoundException;
}
