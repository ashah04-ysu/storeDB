package storedbexample.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import storedbexample.model.Order;

public class OrderTable {
    private static Connection connection;
    
    public static void setConnection(Connection newConnection) {
        connection = newConnection;
    }
    
    public static List<Order> getUserOrders(String userId) throws SQLException {
        //TODO SELECT ALL ORDERS WHERE USER_ID = userId
        
        Statement statement = connection.createStatement();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ORDER WHERE USER_ID = userID");
        ResultSet resultSet = statement.executeQuery(stringBuilder.toString());
        
        
        List<Order> orders = new ArrayList();
        while(resultSet.next()){
            Order order = new Order();
            order.setId("" + resultSet.getString("id"));
            order.setName(resultSet.getString("name"));
            order.setDate(resultSet.getString("date"));
            
            orders.add(order);
        }
        return orders;
    }
}
