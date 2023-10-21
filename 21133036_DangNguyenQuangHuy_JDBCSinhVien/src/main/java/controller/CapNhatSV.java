package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.StudentDao;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CapNhatSV
{
	 @RequestMapping(value="CapNhatSV",method=RequestMethod.GET,params = "mssv")
	 public String  doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("mssv");
		Student student = new Student(Integer.parseInt(id));
		StudentDao std = new StudentDao();
		Student ketqua;
		try {
			ketqua = std.FindSV(student);
			if (ketqua != null) {
				session.setAttribute("sid", "Có Tồn Tại");
				session.setAttribute("hocsinh", ketqua);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "CapNhat";

	}
	 @RequestMapping(value="CapNhatSV",method=RequestMethod.POST)
	 public String doPost(HttpServletRequest request)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		Student student = new Student(Integer.parseInt(id), name, address);
		StudentDao stD = new StudentDao();
		HttpSession session=request.getSession();
		try {
			if (stD.UpdateStudent(student) > 0) {

				session.setAttribute("thongbaocn", "Bạn Đã Cập Nhật Thành Công !");
				return "redirect:/ListSinhVien";
			} else {
				request.setAttribute("thongbaoloi", "Sinh Viên Không Tồn Tại !");
				return "CapNhat";
			}
		
		} catch (Exception e) {
			return "CapNhat";
		}
	}

}
