package com.demojsf.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demojsf.db.JdbcConnect;

public class LoginDAOImpl {

	public static boolean validate(String user, String password) throws ClassNotFoundException {
		Connection connect = null;
		PreparedStatement ps = null;

		try {
			connect = JdbcConnect.getConnect();
			ps = connect.prepareStatement("Select correo, clave from User where correo = ? and clave = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			//DataConnect.close(con);
		}
		return false;
	}
}