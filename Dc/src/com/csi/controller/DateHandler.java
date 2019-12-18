package com.csi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DateHandler")
public class DateHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DateHandler() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String s = request.getParameter("datee");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/checkdb", "root", "");
			PreparedStatement ps = con.prepareStatement("insert into dt values(?)");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date udate = sdf.parse(s);

			long l = udate.getTime();
			java.sql.Date sdate = new java.sql.Date(l);

			ps.setDate(1, sdate);
			// ps.setDate(2, sdate );
			ps.executeUpdate();
			out.println("date added successfully");
			System.out.println("data added");
			System.out.println("Data Added");
			System.out.println("Hello");

		} catch (ClassNotFoundException | ParseException | SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	//new method added 
	

}
