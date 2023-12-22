package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.custom.impl.OrderDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory() {
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS;
    }
    public  SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER: return new CustomerDAOImpl();
            case ITEM:return new ItemDAOImpl();
            case ORDER:return new OrderDAOImpl();
            case ORDER_DETAILS:return new OrderDAOImpl();
            default:return null;
        }
    }
}
