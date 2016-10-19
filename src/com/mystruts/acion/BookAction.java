package com.mystruts.acion;

import java.sql.*;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.mystruts.acion.AuthorAction;

public class BookAction extends ActionSupport {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
    // 定义MySQL数据库的连接地址
	public static final String DBURL = "jdbc:mysql://rrpmsushspsg.rds.sae.sina.com.cn:10083/bookdb" ;
    // MySQL数据库的连接用户名
	public static final String DBUSER = "zhouhaotian_lab2" ;
    // MySQL数据库的连接密码
	public static final String DBPASS = "zombiez960927" ;
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public Date getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
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

	private String ISBN;
	private String Title;
	private String AuthorID;
	private String Publisher;
	private Date PublishDate;
	private float Price;
	
	private String Name;
	private int Age;
	private String Country;
//	private int RowNum;
	private static String Temp;
	private static String TempAuthorID;
	
	
	public int Total() throws ClassNotFoundException, SQLException
	{
		int RowNum;
		int i = 1;
		Class.forName(DBDRIVER); 
		Connection connect = DriverManager.getConnection(
	    		  DBURL,DBUSER,DBPASS);
		Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from Book");
	      rs.last();
	      RowNum = rs.getRow();
	     if(RowNum==0)
	     {
	    	 return 1;
	     }
//	     System.out.println(RowNum);
	     rs.first();
	    if(i != Integer.parseInt(rs.getString(1)))
	    {
	    	return i;
	    	
	    }
	    else
	    {  
	    	i++;
	    	while (rs.next())
	    	{
	    		if(i != Integer.parseInt(rs.getString(1)))
	    		{
//	    		System.out.println("present :");
//	    		System.out.println(Integer.parseInt(rs.getString(1)));
//	    		System.out.println("i:");
//	    		System.out.println(i);
	    			return i;
	    		}
	    		i++;
	    	}
	    }
		return RowNum+1;
		
		
	}
	
	public String addBook() throws SQLException, ClassNotFoundException
	{
		int Num;
		Num = this.Total();
		/*需要改
		 * 删除后再添加ISBN会出错
		 * 初步想法返回的是中间缺少行的的前一个序号或者都满的就返回总数
		 * */
		ISBN = Num+"";
		//System.out.println("here");
		 Class.forName(DBDRIVER); 
		 Connection conn = null;
	      Statement st = null;
	      String sql ="insert into Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) " +
	              "VALUES('" + ISBN + "','" + Title +"','" + AuthorID +"','" +Publisher+"','" +PublishDate +"','" +Price+"');";
	     // System.out.println(sql);
	      conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	      
	      st = conn.createStatement();
	      st.executeUpdate(sql);
	      st.close();
	      conn.close();	
	      return "success";
	}
	
	public String updateBook() throws SQLException, ClassNotFoundException
	{
		Class.forName(DBDRIVER); 
		Connection conn = null;
	      Statement st = null;
	      String sql ="UPDATE Book SET ISBN = '" + Temp + "',Title='" + Title +"',AuthorID='" + TempAuthorID +"',Publisher='" + Publisher +"',PublishDate='" + PublishDate +"',Price='" + Price+"' Where ISBN="+Temp ; 

	      conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	      st = conn.createStatement();
	      st.executeUpdate(sql);
	      st.close();
	      conn.close();
	      return "success";
		
	}
	
	public String deleBook() throws SQLException, ClassNotFoundException
	{
		Class.forName(DBDRIVER); 
		 Connection conn = null;
	      Statement st = null;
	      String sql ="DELETE FROM Book WHERE ISBN ='" +ISBN+"'"; //NAME是String类型所以应该加引号
	               
	      conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	      st = conn.createStatement();
	      st.executeUpdate(sql);
	      st.close();
	      conn.close();  
		return "success";
		
	}
	
//	public void searchBookinISBN() throws SQLException, ClassNotFoundException
//	{
//		Class.forName(DBDRIVER); 
//		Connection connect = DriverManager.getConnection(
//	    		  DBURL,DBUSER,DBPASS);
//		Statement stmt = connect.createStatement();
//	      ResultSet rs = stmt.executeQuery("select * from Book where ISBN ="+ISBN);
//	            
//	      
//	      
//	      //如何返回所得一行数据？？？？？
//	      //？？？？？
//		
//	}
	
	public String passISBN()
	{
		
		Temp = ISBN;
		TempAuthorID = AuthorID;
		System.out.println(Temp);
		return "success";
	}
	
//	public String NameIn() throws ClassNotFoundException, SQLException
//
//	{
//		AuthorAction author = new AuthorAction();
//		TempAuthorID = author.passID(Name);
//		if(TempAuthorID == null)
//		{
//			return "fail";
//			
//		}
//		Class.forName(DBDRIVER); 
//		Connection conn = null;
//	      Statement st = null;
//	      String sql ="select * from Book where AuthorID="+TempAuthorID;
//
//	      System.out.println(sql);
//	      conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
//	      st = conn.createStatement();
//	      ResultSet rs = st.executeQuery(sql);
//	      
//	      ActionContext.getContext().put("booklist", rs);
//	      
//	      System.out.println(rs);
//	      st.close();
//	      conn.close();
//	      return "success";
//	}
//	public String SearchinName(String name) throws ClassNotFoundException, SQLException
//	{
//		AuthorAction Author = new AuthorAction(); 
//		TempAuthorID = Author.SearchforAuID(name);
//		
//		return "success";
//	}
	
}
