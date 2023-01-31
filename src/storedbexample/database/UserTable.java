package storedbexample.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import storedbexample.model.User;

public class UserTable {
    private static Connection connection;
    
    public static void setConnection(Connection newConnection) {
        connection = newConnection;
    }
    
    public static List<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM USERS");
        ResultSet resultSet = statement.executeQuery(stringBuilder.toString());
        
        List<User> users = new ArrayList();
        while(resultSet.next()) {
            User user = new User();
            user.setId("" + resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            
            users.add(user);
        }
        
        return users;
    }
}
