package bo.custom;

import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOderBO {
    public boolean PurchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException ;

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException ;

    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException ;

    public String generateNewOrderId() throws SQLException, ClassNotFoundException ;

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;

    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
