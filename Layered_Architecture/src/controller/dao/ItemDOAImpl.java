package controller.dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDOAImpl {

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> allItem = new ArrayList<>();
        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            BigDecimal unitPrice = rst.getBigDecimal(4);
            int qtyOnHand = rst.getInt(3);
            allItem.add(new ItemDTO(code, description, unitPrice, qtyOnHand));
        }
        return allItem;
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeUpdate() > 0;
    }

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());
        return pstm.executeUpdate() > 0;
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2, dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());
        return pstm.executeUpdate() > 0;
    }

    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }

    public String generateNewItemId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
}
