package dao;

import java.sql.SQLException;

import model.Customer;

public interface CustomerInt {
	public void read() throws SQLException;
	public void update(Customer c) throws SQLException;
	public void insert(Customer c) throws SQLException;
	public void delete(Customer c) throws SQLException;
}
