package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemOb {
    ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean exitsItem(String code) throws SQLException, ClassNotFoundException;
    String genarateItemCode() throws SQLException, ClassNotFoundException;
}
