package dao;

import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO{

    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException ;

    public String generateNewItemId() throws SQLException, ClassNotFoundException ;
}
