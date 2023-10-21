package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseConnection;

public class AccountDao {

	DataBaseConnection dbc = new DataBaseConnection();

	public int check(Account ac) throws SQLException, ClassNotFoundException {
		String sql = "select *From user_account where user_name='" + ac.getUsername() + "'" + "and password='"
				+ ac.getPassword() + "'";

		ResultSet rs = dbc.GetValue(sql);
		if (rs.next() == true) {
			return 1;
		} else {
			return 0;
		}
	}
}
