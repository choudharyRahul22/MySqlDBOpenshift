package com.optum.iris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbResource {

	@RequestMapping("/")
	public String get() {

		if (getConnection() != null) {
			return "Connection made successfull!";
		} else {
			return "unable to made connection";
		}
	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/sampledb", "iris", "iris");

			if (con != null) {

				return con;

			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
