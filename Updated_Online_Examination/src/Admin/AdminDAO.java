package Admin;
import Questions.*;
import Student.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO 
{
	public static Connection GetConnection(String database)
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String connection="jdbc:mysql://localhost:3306/"+database;
			con=DriverManager.getConnection(connection,"root","root");
		}
		catch(Exception e)
		{
			System.out.println("Getting Connection Error "+e);
		}
		return con;
	}
	
	public static int Store_Admin(Admin a)
	{
		int s=0;
		try
		{
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			PreparedStatement ps=con.prepareStatement("insert into admindetails values(?,?,?,?,?)");
			ps.setString(1,a.getName());
			ps.setString(2,a.getOrganization());
			ps.setString(3,a.getEmail());
			ps.setString(4,a.getContact());
			ps.setString(5,a.getPassword());
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Storing Admin Details"+e);
		}
		return s;
	}
	
	public static Admin Get_Admin_Details(String email)
	{
		Admin a =new Admin();
		try
		{
			
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			PreparedStatement ps=con.prepareStatement("select * from admindetails where email=?");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				a.setName(rs.getString("name"));
				a.setOrganization(rs.getString("organization"));
				a.setContact(rs.getString("contact"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Admin Details"+e);
		}
		return a;
	}
	
	public static Admin Get_Admin_Details_By_Name(String name)
	{
		Admin a =new Admin();
		try
		{
			
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			PreparedStatement ps=con.prepareStatement("select * from admindetails where name=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				a.setName(rs.getString("name"));
				a.setOrganization(rs.getString("organization"));
				a.setContact(rs.getString("contact"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Admin Details"+e);
		}
		return a;
	}
	
	public static ArrayList<Admin> Get_Admin_Details()
	{
		ArrayList<Admin> list=new ArrayList<>();
		try
		{
			
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			PreparedStatement ps=con.prepareStatement("select * from admindetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Admin a=new Admin();
				a.setName(rs.getString("name"));
				a.setOrganization(rs.getString("organization"));
				a.setContact(rs.getString("contact"));
				a.setEmail(rs.getString("email"));
				a.setPassword(rs.getString("password"));
				list.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Admin Details"+e);
		}
		return list;
	}
	
	public static int Create_Admin_Database(Admin a)
	{
		int s=0;
		try
		{		
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			String database=a.getEmail().substring(0,a.getEmail().indexOf('@'));
			String query="create database "+database;
			PreparedStatement ps=con.prepareStatement(query);
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Creating Admin Database"+e);
		}
		return s;
	}
	
	public static void Create_Admin_TestTable(String email)
	{
		try
		{
			String database=email.substring(0, email.indexOf('@'));
			Connection con=AdminDAO.GetConnection(database);
			PreparedStatement ps=con.prepareStatement("create table admintests(tests varchar(100))");
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Creating Admin testtable");
		}
	}
	
	public static void Create_Admin_StudentTable(String email)
	{
		try
		{
			String database=email.substring(0, email.indexOf('@'));
			Connection con=AdminDAO.GetConnection(database);
			PreparedStatement pss=con.prepareStatement("create table studentdetails(firstname varchar(100), lastname varchar(100), email varchar(100), dob varchar(10), phone varchar(100), age int(2), gender varchar(10), password varchar(100))");
			pss.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Creating Admin studenttable");
		}
	}

	public static int Save_Student_Into_Admin_Database(String adminmail, Student s)
	{
		int ss=0;
		try
		{
			String db=adminmail.substring(0, adminmail.indexOf('@'));
			Connection con=AdminDAO.GetConnection(db);
			String query="insert into studentdetails values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,s.getFirstname());
			ps.setString(2,s.getLastname());
			ps.setString(3,s.getEmail());
			ps.setString(4,s.getDob());
			ps.setString(5,s.getPhone());
			ps.setInt(6,s.getAge());
			ps.setString(7,s.getGender());
			ps.setString(8,s.getPassword());
			ss+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Saving Student into Admin "+e);
		}
		return ss;
	}
	
	public static Student Get_Student_From_Admin_Database(String adminemail, String email)
	{
		Student s=new Student();
		try
		{
			Connection con=AdminDAO.GetConnection(adminemail.substring(0, adminemail.indexOf('@')));
			PreparedStatement ps=con.prepareStatement("select * from studentdetails where email=? ");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s.setFirstname(rs.getString("firstname"));
				s.setLastname(rs.getString("lastname"));
				s.setEmail(rs.getString("email"));
				s.setDob(rs.getString("dob"));
				s.setGender(rs.getString("phone"));
				s.setAge(rs.getInt("age"));
				s.setPhone(rs.getString("gender"));
				s.setPassword(rs.getString("password"));
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Student From Admin "+e);
		}
		return s;
	}
	
	public static int Insert_Into_Admin_TestTable(Admin a, String testname)
	{
		int s=0;
		try
		{
			String database=a.getEmail().substring(0,a.getEmail().indexOf('@'));
			Connection con=AdminDAO.GetConnection(database);
			PreparedStatement ps=con.prepareStatement("insert into admintests values(?)");
			ps.setString(1,testname);
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in storing table in admin database "+e);
		}
		return s;
	}
	
	public static int Delete_Test_From_Admin(String admin, String testname)
	{
		int s=0;
		try
		{
			String database=admin.substring(0,admin.indexOf('@'));
			Connection con=AdminDAO.GetConnection(database);
			PreparedStatement ps=con.prepareStatement("delete from admintests where tests=?");
			ps.setString(1,testname);
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Deleting Test from Admin");
		}
		return s;
	}
	
	public static ArrayList Get_Admin_Tests(String email)
	{
		ArrayList<String> list=new ArrayList<>();
		try
		{
			String database=email.substring(0,email.indexOf('@'));
			Connection con=AdminDAO.GetConnection(database);
			PreparedStatement ps=con.prepareStatement("select * from admintests");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString("tests"));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in getting table from admin database "+e);
		}
		return list;
	}
	
	public static int Create_Test_Database(String name)
	{
		int s=0;
		try
		{
			Connection con=AdminDAO.GetConnection("updatedonlineexamination");
			String query="create database "+name;
			PreparedStatement ps=con.prepareStatement(query);
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Creating Test Database "+e);
		}
		return s;
	}
	
	public static int Drop_Test_Database(String testname)
	{
		int s=0;
		try
		{
			Connection con=AdminDAO.GetConnection(testname);
			String query="drop database "+testname;
			PreparedStatement ps=con.prepareStatement(query);
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Dropping Test Database "+e);
		}
		return s;
	}
	
	public static int Create_Test_Level_Tables(String testdbname, int level)
	{
		System.out.println(testdbname);
		System.out.println(level);
		int s=0;
		int i=1;
		try
		{
			Connection con=AdminDAO.GetConnection(testdbname);
			while(i<=level)
			{
				String query="create table level"+i+"(no int(10) unique, question varchar(1000), option1 varchar(100), option2 varchar(100), option3 varchar(100), option4 varchar(100), answer varchar(100))";
				PreparedStatement ps=con.prepareStatement(query);
				System.out.println(ps.executeUpdate());
				s+=1;
				i+=1;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Creating TestLevel Tables "+e);
		}
		return s;
	}
	
	public static int Insert_Questions(String testdbname, String level, Questions q)
	{
		int s=0;
		try
		{
			//System.out.println(testdbname);
			//System.out.println(level);
			
			Connection con=AdminDAO.GetConnection(testdbname);
			String query="insert into level"+level+" values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,q.getNo());
			ps.setString(2,q.getQue());
			ps.setString(3,q.getO1());
			ps.setString(4,q.getO2());
			ps.setString(5,q.getO3());
			ps.setString(6,q.getO4());
			ps.setString(7,q.getAns());
			s+=ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in Inserting Questions "+e);
		}
		return s;
	}
	
	public static ArrayList Get_Admin_Test_Levels(String testname)
	{
		ArrayList<String> list=new ArrayList<>();
		try
		{
			Connection con=AdminDAO.GetConnection(testname);
			String query="SELECT table_name FROM information_schema.tables WHERE table_schema='"+testname+"'";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in Getting Admin Test Levels "+e);
		}
		return list;
	}
	
	public static ArrayList<Questions> Get_All_Questions(String testdbname, String level)
	{
		ArrayList<Questions> list=new ArrayList<Questions>();
		PreparedStatement ps=null;
		try
		{
			Connection con= AdminDAO.GetConnection(testdbname);
			String query="select * from level"+level;
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Questions q=new Questions();
				q.setNo(rs.getInt("no"));
				q.setQue(rs.getString("question"));
				q.setO1(rs.getString("option1"));
				q.setO2(rs.getString("option2"));
				q.setO3(rs.getString("option3"));
				q.setO4(rs.getString("option4"));
				q.setAns(rs.getString("answer"));
				list.add(q);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Getting All Questions Error "+e);
		}
		return list;
	}
	
	public static Questions GetQuestion(String testdbname, int level, int db_que_no)
	{
		Questions q=new Questions();
		try
		{
			Connection con=AdminDAO.GetConnection(testdbname);
			String query="select * from level"+level+" where no="+db_que_no;
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				q.setQue(rs.getString("question"));
				q.setO1(rs.getString("o1"));
				q.setO2(rs.getString("o2"));
				q.setO3(rs.getString("o3"));
				q.setO4(rs.getString("o4"));
				q.setAns(rs.getString("ans"));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("Getting Question Error "+e);
		}
		return q;
	}
}

