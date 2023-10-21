package model;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import database.DataBaseConnection;
public class StudentDao {
	DataBaseConnection dbC =new DataBaseConnection();
	public List<Student> DanhSach() throws ClassNotFoundException, SQLException {
		   
		ResultSet rs=dbC.GetValue("select *From student");
		List<Student> lisths=new ArrayList<Student>();
		while(rs.next())
		{
			Student student= new Student(rs.getInt("id"),rs.getString("name"),rs.getString("address"));
			lisths.add(student);
		}
		return lisths;
	}
	public int AddStudent(Student student) throws ClassNotFoundException, SQLException
	{
		String sql="Insert into student(id,name,address)"
				+"Values("+student.getMssv()+",N'"+student.getName()+"',N'"+student.getAddress()+"')";
		int ketqua=dbC.Execute(sql);	
		return ketqua;
	}
	public int UpdateStudent(Student student) throws ClassNotFoundException, SQLException
	{
		String sql="Update student set name= N'"+student.getName()+"',address=N'"+student.getAddress()+"'"
				+ "where id="+student.getMssv()+"";
		int ketqua=dbC.Execute(sql);
		return ketqua;
	}
	public int DeleteStudent(Student student) throws ClassNotFoundException, SQLException
	{
		String sql="Delete student where id ="+student.getMssv()+"";
		int ketqua=dbC.Execute(sql);
		return ketqua;
		
	}
	public Student FindSV(Student student) throws ClassNotFoundException, SQLException {
	    String sql="Select *From student where id="+student.getMssv()+"";
	    ResultSet rs=dbC.GetValue(sql);
	    if(rs.next()==true)
	    {
	    	student=new Student(rs.getInt("id"),rs.getString("name"),rs.getString("address"));
	    	return student;
	    }
	    return null;
	}

	
}
