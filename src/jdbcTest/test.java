package jdbcTest;

import java.sql.SQLException;
import java.util.Scanner;

import dao.CustomerImplementation;
import model.Customer;

public class test {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		System.out.println("Welcome! \nWhat do you want to do? \nCreate? Read? Update? Delete?");
		String userChoice = sc.next();
		
		CustomerImplementation c = new CustomerImplementation();
		Customer cs = new Customer();
		
		switch (userChoice) {
		case "create":
			System.out.println("Enter Name?");
			cs.setName(sc.next());
			System.out.println("Enter Age?");
			cs.setAge(sc.nextInt());
			System.out.println("Enter Address?");
			cs.setAddress(sc.next());
			c.insert(cs);
			break;
		case "read":
			c.read();
			break;
		case "update":
			System.out.println("Enter the ID you want to Update:");
			cs.setId(sc.nextInt());
			System.out.println("New Name?");
			cs.setName(sc.next());
			System.out.println("New Age?");
			cs.setAge(sc.nextInt());
			System.out.println("New Address?");
			cs.setAddress(sc.next());
			c.update(cs);
			break;
		case "delete":
			System.out.println("Enter the ID you want to Delete:");
			cs.setId(sc.nextInt());
			c.delete(cs);
			break;
		}
	}

}
