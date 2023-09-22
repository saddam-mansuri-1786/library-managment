package book.mgmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import book.mgmt.entity.User;
import book.mgmt.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	private final String REGISTER_USER = "INSERT INTO users (username,password) VALUES(?,?)";
	private final String CHECK_USER = "SELECT * FROM users WHERE username = ? AND password = ?";

	private Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName(DBUtils.DRIVER);
		Connection con = DriverManager.getConnection(DBUtils.URL, DBUtils.USERNAME, DBUtils.PASSWORD);
		return con;
	}

	@Override
	public int registerUser(User user) throws ClassNotFoundException, SQLException {

		int result = 0;
		try (	Connection con = getConnection(); 
				PreparedStatement pStmt = con.prepareStatement(REGISTER_USER)) {

			pStmt.setString(1, user.getUsername());
			pStmt.setString(2, user.getPassword());

			result = pStmt.executeUpdate();
		}

		return result;
	}

	@Override
	public boolean authenticateUser(String username, String password) throws ClassNotFoundException, SQLException {

		boolean isUserRegistered = false;
		ResultSet rSet = null;

		try (Connection con = getConnection(); 
				PreparedStatement pStmt = con.prepareStatement(CHECK_USER)) {

			pStmt.setString(1, username);
			pStmt.setString(2, password);

			rSet = pStmt.executeQuery();
			
	//if the user details found rSet.next() return true otherwise return false		
			isUserRegistered = rSet.next();
		} finally {
			if (rSet != null) {
				rSet.close();
			}
		}

		return isUserRegistered;

	}

}
