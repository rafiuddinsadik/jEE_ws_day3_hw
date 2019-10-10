package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.Customer;
import util.databaseConnectivity;

public class CustomerImplementation implements CustomerInt {
	Scanner sc = new Scanner(System.in);

	@Override
	public void read() throws SQLException {
		Connection con = databaseConnectivity.con;

		String query = "SELECT * FROM customer";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " "
					+ rs.getString("address"));
		}

	}

	@Override
	public void update(Customer c) throws SQLException {
		Connection con = databaseConnectivity.con;
		String query = "UPDATE customer set name=?, age=?, address=? WHERE id=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setInt(2, c.getAge());
			ps.setString(3, c.getAddress());
			ps.setInt(4, c.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("Successfully Updated!");
		read();
	}

	@Override
	public void insert(Customer c) throws SQLException {
		Connection con = databaseConnectivity.con;
		String query = "INSERT INTO customer (name, age, address) " + "	VALUES (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setInt(2, c.getAge());
			ps.setString(3, c.getAddress());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("Insertion Successful!");
		read();
	}

	@Override
	public void delete(Customer c) throws SQLException {
		Connection con = databaseConnectivity.con;

		String select = "SELECT name FROM customer WHERE id = ?";
		PreparedStatement ps;
		ps = con.prepareStatement(select);
		ps.setInt(1, c.getId());
		ResultSet res = ps.executeQuery();
		String name = "";
		res.next();
		name = res.getString("name");

		String query = "DELETE FROM customer WHERE id = ?";
		ps = con.prepareStatement(query);
		ps.setInt(1, c.getId());
		ps.executeUpdate();

		System.err.println("Successfully deleted records for " + name);

		read();
	}

}
