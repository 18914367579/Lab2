package com.mystruts.acion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AuthorAction extends ActionSupport {

	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// 定义MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://rrpmsushspsg.rds.sae.sina.com.cn:10083/bookdb";
	// MySQL数据库的连接用户名
	public static final String DBUSER = "zhouhaotian_lab2";
	// MySQL数据库的连接密码
	public static final String DBPASS = "zombiez960927";

	private String AuthorID;
	private String Name;
	private int Age;
	private String Country;
	private static String ID;

	private static String description;

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		AuthorAction.description = description;
	}

	public String getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String addAuthor() throws ClassNotFoundException, SQLException {

		Class.forName(DBDRIVER);
		Connection conn = null;
		Statement st = null;
		String sql = "insert into Author(AuthorID ,Name,Age,Country) " + "VALUES('" + AuthorID + "','" + Name + "','"
				+ Age + "','" + Country + "');";
		// System.out.println(sql);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

		st = conn.createStatement();
		st.executeUpdate(sql);
		st.close();
		conn.close();
		return "success";

	}

	public String passID() throws ClassNotFoundException, SQLException {
		int num;
		Class.forName(DBDRIVER);
		Connection connect = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Author where Name = '" + Name + "'");
		if (rs.next())
			ActionContext.getContext().put("ID", rs.getString(1));
		rs.last();
		num = rs.getRow();
		if (num == 0) {
			return "fail";
		}
		return "success";

	}

	public String passAuthorID() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connect = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Author where AuthorID = " + AuthorID);
		if (rs.next()) {
			description = "本书作者名为" + rs.getString(2) + "," + rs.getString(3) + "岁" + "," + rs.getString(4) + "人";
		}
		ActionContext.getContext().put("de", description);
		return "success";
	}

	public String checkID() throws ClassNotFoundException, SQLException {
		int num;
		Class.forName(DBDRIVER);
		Connection connect = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Author where AuthorID = " + AuthorID);
		if (rs.next())
			ActionContext.getContext().put("ID", rs.getString(1));
		rs.last();
		num = rs.getRow();
		if (num == 0) {
			return "none";

		}
		return "exsist";

	}

}
