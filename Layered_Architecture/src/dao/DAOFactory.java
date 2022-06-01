package dao;

import dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();  //SuperDAO superDAO=new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();  //SuperDAO superDAO=new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();   //SuperDAO superDAO=new OrderDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();   //SuperDAO superDAO=new OrderDetailsDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();   //SuperDAO superDAO=new QueryDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }
}

