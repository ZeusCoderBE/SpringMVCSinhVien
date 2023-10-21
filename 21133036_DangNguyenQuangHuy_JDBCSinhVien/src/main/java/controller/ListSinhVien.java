package controller;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import model.*;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListSinhVien 
{
	@RequestMapping(value="/ListSinhVien")
	public String doGet(HttpServletRequest request)
	{
		List<Student> listST = null;
		try {
			StudentDao studentdao = new StudentDao();
			listST = studentdao.DanhSach();
			request.setAttribute("dsHocSinh", listST);
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();

		}
		return "SinhVienListView";
	}
}
