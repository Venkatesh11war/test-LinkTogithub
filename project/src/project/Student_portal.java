package project;
import java.util.Scanner;
import java.sql.*;
class Admin
{
	void singin()
	{
	try
	{
	long phno;
	String uname,pword;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your name");
	uname=s.next();
	System.out.println("Enter password");
	pword=s.next();
	System.out.println("Enter phno");
	phno=s.nextLong();

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
	PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?)");
	ps.setString(1, uname);
	ps.setString(2, pword);
	ps.setLong(3, phno);
	ps.executeUpdate();
	System.out.println("Data saved.....");
	s.close();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	}
	void reset_password()
	{
		try
		{
		long phno;
		String newpassword;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your new password");
		newpassword=s.next();
		System.out.println("Enter your phno");
		phno=s.nextLong();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
		PreparedStatement ps=con.prepareStatement("update admin set password=? where phno=?");
		ps.setString(1, newpassword);
		ps.setLong(2, phno);
		int k=ps.executeUpdate();
		if(k!=0)
		{
			System.out.println(k+" Row affected");
		}
		else 
		{
			System.out.println("Row was not affected");
		}
		s.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		
	}}	
	void login() 
	{
		String un,passwd;
		String namedb,pw;
		namedb="";
		pw="";
		
		try
		{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter user name: ");
		un=s.next();
		System.out.println("Enter password: ");
		passwd=s.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select username,password from admin");
		
		while(rs.next()) {
		namedb=rs.getString("username");
		pw=rs.getString("password");
		
		if(un.equals(namedb)&& passwd.equals(pw))
		{
			System.out.println("welcome "+un);
			break;
		}
		else 
		{
			System.out.println("invalid username or password");
		}
		s.close();
		}}
		catch(Exception e)
		{	
			System.out.print(e);
		}}}
class studentinfo extends Admin
{
	void add()
	{
		try
		{
		String name,location,dob,department,parent_name,cast,blood_group,address;
		int studend_id,age;
		long phno,bank_accno;	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your name: ");
		name=s.next();
		System.out.println("Enter your id: ");
		studend_id=s.nextInt();
		System.out.println("Enter your date of birth: ");
		dob=s.next();
		System.out.println("Enter your location: ");
		location=s.next();
		System.out.println("Enter your department: ");
		department=s.next();
		System.out.println("Enter your age: ");
		age=s.nextInt();
		System.out.println("Enter your phno: ");
		phno=s.nextLong();
		System.out.println("Enter your parent name: ");
		parent_name=s.next();
		System.out.println("Enter your cast: ");
		cast=s.next();
		System.out.println("Enter your blood group: ");
		blood_group=s.next();
		System.out.println("Enter your bank acc no: ");
		bank_accno=s.nextLong();
		System.out.println("Enter your address: ");
		address=s.next();
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
		PreparedStatement ps=con.prepareStatement("insert into studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
		ps.setString(1, name);
		ps.setInt(2, studend_id);
		ps.setString(3, dob);
		ps.setString(4, location);
		ps.setString(5, department);
		ps.setInt(6, age);
		ps.setLong(7, phno);
		ps.setString(8, parent_name);
		ps.setString(9, cast);
		ps.setString(10, blood_group);
		ps.setLong(11, bank_accno);
		ps.setString(12, address);
		ps.executeUpdate();
		con.close();
		System.out.println("Data saved.....");
		s.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}}
void modyfi()
	{
	try
	{
	long phno;
	String name;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your name");
	name=s.next();
	System.out.println("Enter your phno");
	phno=s.nextLong();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
	PreparedStatement ps=con.prepareStatement("update studentinfo set phno=? where name=?");
	ps.setLong(1, phno);
	ps.setString(2, name);
	int r=ps.executeUpdate();
	if(r!=0)
	{
		System.out.println(r+" Row affected");
	}
	else 
	{
		System.out.println("Row was not affected");
	}
	s.close();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}}
void delete()
	{
	try
	{
	String name;
	Scanner s=new Scanner(System.in);
	System.out.println("Enter your name");
	name=s.next();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
	PreparedStatement ps=con.prepareStatement("delete from studentinfo where name=?");
	ps.setString(1, name);
	int r=ps.executeUpdate();
	if(r!=0)
	{
		System.out.println(r+" Row deleted");
	}
	else 
	{
		System.out.println("Row was not affected");
	}
	s.close();
	con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}}
void read()
	{
	try
    {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select*from placementinfo");
	while(rs.next())
	{
		System.out.println("officer name: "+rs.getString(1));
		System.out.println("officer mail: "+rs.getString(2));
		System.out.println("phno: "+rs.getLong(3));
		System.out.println("interview date: "+rs.getString(4));
		System.out.println("technology: "+rs.getString(5));
		System.out.println("salary: "+rs.getLong(6));
		System.out.println("lock in period: "+rs.getInt(7));
		System.out.println("eligible year: "+rs.getInt(8));
		System.out.println("eligible degree: "+rs.getString(9));
		System.out.println("no.of vacant: "+rs.getInt(10));
		System.out.println("mail resume on or before: "+rs.getString(11));
		System.out.println("..... ");
	}con.close();
	}
catch(Exception e)
	{
	System.out.println(e);	
	}}}
public class Student_portal extends Admin
	{
	void interview_info()
	{
		try
		{
		String placemnt_officer_name,po_mail,technology,eligibility_degree,interview_date,mail_resume_on_or_before;
		int lock_in_period,eligbility_year,no_of_vacant;
		long po_phno,salary;	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your placement officer name: ");
		placemnt_officer_name=s.next();
		System.out.println("Enter your placement_officer mail: ");
		po_mail=s.next();
		System.out.println("Enter your placement_officer phone number: ");
		po_phno=s.nextLong();
		System.out.println("Enter interview date: ");
		interview_date=s.next();
		System.out.println("Enter technology: ");
		technology=s.next();
		System.out.println("Enter salary: ");
		salary=s.nextLong();
		System.out.println("Enter lock in period: ");
		lock_in_period=s.nextInt();
		System.out.println("Enter eligibile year: ");
		eligbility_year=s.nextInt();
		System.out.println("Enter elgibility degree: ");
		eligibility_degree=s.next();
		System.out.println("Enter no of vacant: ");
		no_of_vacant=s.nextInt();
		System.out.println("Enter mail_resume_on_or_before: ");
		mail_resume_on_or_before=s.next();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
		PreparedStatement ps=con.prepareStatement("insert into placementinfo values(?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, placemnt_officer_name);
		ps.setString(2, po_mail);
		ps.setLong(3, po_phno);
		ps.setString(4, interview_date);
		ps.setString(5, technology);
		ps.setLong(6, salary);
		ps.setInt(7, lock_in_period);
		ps.setInt(8, eligbility_year);
		ps.setString(9, eligibility_degree);
		ps.setInt(10, no_of_vacant);
		ps.setString(11, mail_resume_on_or_before);
		ps.executeQuery();
		con.close();
		
		System.out.println("Data saved.....");
		s.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}}
	void stdread()
	{
		try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_portal","root","");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select*from studentinfo");
		while(rs.next())
		{
			System.out.println("Student name: "+rs.getString(1));
			System.out.println("Student id: "+rs.getInt(2));
			System.out.println("dob "+rs.getString(3));
			System.out.println("location "+rs.getString(4));
			System.out.println("department "+rs.getString(5));
			System.out.println("age "+rs.getInt(6));
			System.out.println("phno "+rs.getLong(7));
			System.out.println("parent name "+rs.getString(8));
			System.out.println("cast "+rs.getString(9));
			System.out.println("blood group "+rs.getString(10));
			System.out.println("nank account no "+rs.getLong(11));
			System.out.println("Address "+rs.getString(12));
			System.out.println("..... ");
			
		}
		con.close();
		}
	catch(Exception e)
	{
		System.out.println(e);	
	}
	}
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("1.new user\n2.forgot password\n2.Student information\n3.Interview information");
		int ch=s.nextInt();
		
		if(ch==1) {
			Admin z=new Admin();
			z.singin();	
		}
		else if (ch==2)
		{
			Admin n=new Admin();
			n.reset_password();
			
		}
		else if(ch==3)
		{
			int a;
			System.out.println("1.Student new record\n2.Student record modify\n3.Delete studdent record\n4.read interview information");
			a=s.nextInt();
			
			if(a==1)
			{
				studentinfo t=new studentinfo();
				t.login();
				t.add();
			}
			else if(a==2)
			{
				studentinfo m=new studentinfo();
				m.login();
				m.modyfi();
			}
			else if(a==3)
			{
				studentinfo d=new studentinfo();
				d.login();
				d.delete();
			}
			else if(a==4)
			{
				studentinfo read=new studentinfo();
				read.login();
				read.read();
			}
			
		}
		else if(ch==4)
		{
			int x;
			System.out.println("1.interview new record\n2.Read Student record");
			x=s.nextInt();
			if(x==1)
			{
				Student_portal info=new Student_portal();
				info.login();
				info.interview_info();
				
			}
			else if (x==2)
			{
				Student_portal read=new Student_portal();
				read.login();
				read.stdread();
			}
			s.close();
				
			}}}
