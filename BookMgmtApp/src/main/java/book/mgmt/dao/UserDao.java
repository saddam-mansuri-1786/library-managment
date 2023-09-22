package book.mgmt.dao;

import java.sql.SQLException;

import book.mgmt.entity.User;

public interface UserDao {

	int registerUser(User user) throws ClassNotFoundException, SQLException;

	boolean authenticateUser(String username, String password) throws ClassNotFoundException, SQLException;

}
