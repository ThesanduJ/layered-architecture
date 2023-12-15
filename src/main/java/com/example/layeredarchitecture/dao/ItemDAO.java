package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;

     boolean isDelete(String code) throws SQLException, ClassNotFoundException;

     boolean isAdd(ItemDTO dto) throws SQLException, ClassNotFoundException ;

     boolean isExits(String code) throws SQLException, ClassNotFoundException;

     String GenarateCode() throws SQLException, ClassNotFoundException;
}
