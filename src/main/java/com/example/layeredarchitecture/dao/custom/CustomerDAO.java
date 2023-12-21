package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
//    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
//
//    boolean saveCustomer(String id, String name, String address) throws SQLException, ClassNotFoundException;
//
//    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
//
//    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
//
//    boolean exitsCustomer(String id) throws SQLException, ClassNotFoundException;
//
//    String genarateId() throws SQLException, ClassNotFoundException;
//
    String searchCustomer(Object newValue) throws SQLException, ClassNotFoundException;
}
