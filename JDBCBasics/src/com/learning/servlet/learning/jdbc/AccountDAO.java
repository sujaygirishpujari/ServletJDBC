package com.learning.servlet.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

public class AccountDAO {

	@Test
	void execqueteQuery() {
		String user = "root";
		String password = "password@123";

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", user, password);
				Statement createStatement = connection.createStatement();
				ResultSet rs = createStatement.executeQuery("select * from account");) {

			System.out.println(connection);

			while (rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void deleteAccount() {
		String user = "root";
		String password = "password@123";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", user, password);
			System.out.println(connection);
			try (Statement createStatement = connection.createStatement()) {

				int result = createStatement.executeUpdate("delete from account where accno=1");
				System.out.println(result + " rows got deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void updateAccount() {
		String user = "root";
		String password = "password@123";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", user, password);
			System.out.println(connection);
			try (Statement createStatement = connection.createStatement()) {

				int result = createStatement.executeUpdate("update account set bal=5000 where accno=1");
				System.out.println(result + " rows got uodate");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user = "root";
		String password = "password@123";

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", user, password);
			System.out.println(connection);
			try (Statement createStatement = connection.createStatement()) {

				int result = createStatement.executeUpdate("insert into account values(1,'sujay','pujari',1000)");
				System.out.println(result + " rows got inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
