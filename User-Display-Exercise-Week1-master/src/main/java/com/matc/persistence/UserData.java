package com.matc.persistence;

import com.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    private boolean userFound;

    public boolean isUserFound() {
        return userFound;
    }

    public void setUserFound(boolean userFound) {
        this.userFound = userFound;
    }


    public List<User> processSearch(String searchType, String searchTerm){
        String newSql;

        if(searchType.equals("allUsers")){
            newSql = "SELECT * FROM users";
        } else {
            newSql = "SELECT * FROM users WHERE last_name = '" + searchTerm + "';";
        }
        List<User> myUsers = new ArrayList<User>();
        myUsers = getAllUsers(newSql);

        return myUsers;
    }
    public List<User> getAllUsers(String newSql) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = newSql;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            if (results.isBeforeFirst()) {
                setUserFound(true);
            }

            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        user.calculateAge();
        return user;
    }

}
