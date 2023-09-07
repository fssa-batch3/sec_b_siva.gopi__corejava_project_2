package in.fssa.agzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.fssa.agzone.exception.PersistanceException;
import in.fssa.agzone.model.User;
import in.fssa.agzone.util.ConnectionUtil;

public class UserDAO {

	public void create(User user) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO users ( farmer_name , mobile_number, district, town,password ) VALUES ( ?, ?, ?, ?, ? );";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setLong(2, user.getMobileNumber());
			ps.setString(3, user.getDistrict());
			ps.setString(4, user.getTown());
			ps.setString(5, user.getPassword());

			ps.executeUpdate();

			System.out.println("User Successfully Created :)");

		} catch (SQLException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				throw new PersistanceException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new PersistanceException(e.getMessage());
			}

		} finally {
			ConnectionUtil.close(con, ps);
		}

	}
	
	public void update(long MobileNumber, User newUser) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET farmer_name = ?, district = ? , town = ? , password = ? WHERE mobile_number = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getName());
			ps.setString(3, newUser.getDistrict());
			ps.setString(4, newUser.getTown());
			ps.setString(5, newUser.getPassword());
			ps.setLong(5, MobileNumber);

			ps.executeUpdate();

			System.out.println("User Successfully Updated :)");

		} catch (SQLException e) {

			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}

	}
	
	public User findByMobileNumber(long MobileNumber) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		User user = null;

		try {
			String query = "SELECT farmer_name,mobile_number,district,town,id FROM users  WHERE mobile_number = ? ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, MobileNumber);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("farmer_name"));
				user.setMobileNumber(rs.getLong("mobile_number"));
				user.setDistrict(rs.getString("district"));
				user.setTown(rs.getString("town"));
				user.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		return user;
	}

}