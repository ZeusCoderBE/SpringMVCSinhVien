package model;

public class Account {
	private String username;
	private String password;
	public  String getUsername ()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}

	public Account(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	public Account()
	{
		
	}
	
}
