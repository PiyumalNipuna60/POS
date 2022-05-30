package controller.dao;

import db.DBConnection;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

     boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

     void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

     boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String generateNewId() throws SQLException, ClassNotFoundException ;
}
