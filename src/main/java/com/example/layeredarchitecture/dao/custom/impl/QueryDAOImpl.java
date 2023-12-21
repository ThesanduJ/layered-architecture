package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.PlaceOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public PlaceOrderDTO printDeatils() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT\n" +
                "    o.oid AS order_id,\n" +
                "    o.date AS order_date,\n" +
                "    c.id AS customer_id,\n" +
                "    c.name AS customer_name,\n" +
                "    od.itemCode AS item_code,\n" +
                "    i.description AS item_description,\n" +
                "    od.qty AS quantity,\n" +
                "    od.unitPrice AS unit_price\n" +
                "FROM\n" +
                "    Orders o\n" +
                "JOIN\n" +
                "    Customer c ON o.customerID = c.id\n" +
                "JOIN\n" +
                "    OrderDetails od ON o.oid = od.oid\n" +
                "JOIN\n" +
                "    Item i ON od.itemCode = i.code;\n");

        resultSet.next();
        return new PlaceOrderDTO(
                resultSet.getString(1),
                resultSet.getDate(2).toLocalDate(),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getString(6),
                resultSet.getInt(7),
                resultSet.getBigDecimal(8)
        );
    }
}
