package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Student;
import model.StudentDao;

@Controller
public class XoaSV  {

	@RequestMapping(value="XoaSV",method=RequestMethod.GET)
	public String doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Student st = new Student(Integer.parseInt(id));
		StudentDao stD = new StudentDao();
		HttpSession session=request.getSession();
		try {
			if (stD.FindSV(st) != null && stD.DeleteStudent(st) > 0) {
				session.setAttribute("thongbaox", "Bạn Đã Xoá Thành Công!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		return "redirect:/ListSinhVien";
	}


}
