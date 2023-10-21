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
public class DangKySV {
	@RequestMapping(value = "DangKySV", method = RequestMethod.GET)
	public String doGet() {
		return "DangKy";
	}

	@RequestMapping(value = "DangKySV", method = RequestMethod.POST)
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("fullname");
		String address = request.getParameter("address");
		Student student = new Student(Integer.parseInt(id), name, address);
		StudentDao std = new StudentDao();
		HttpSession session = request.getSession();
		try {
			if (std.AddStudent(student) > 0) {
				session.setAttribute("thongbaodk", "Bạn Đã Đăng Kí Thành Công !");
				return "redirect:/ListSinhVien";
			} else {
				request.setAttribute("thongbaoloi", "Thất Bại!");
				return "DangKy";
			}

		} catch (ClassNotFoundException | SQLException e) {
			return "DangKy";
		}

	}

}
