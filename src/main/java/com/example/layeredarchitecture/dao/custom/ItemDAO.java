package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<ItemDTO> {

    ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;

    ItemDTO searchItem(Object newItemCode) throws SQLException, ClassNotFoundException;

}
