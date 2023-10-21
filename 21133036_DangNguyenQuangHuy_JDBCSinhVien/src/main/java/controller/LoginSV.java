package controller;

import jakarta.servlet.http.HttpServletRequest;
import model.Account;
import model.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginSV
{    
	 @RequestMapping(value="dang-nhap",method=RequestMethod.POST)
	 public String doGet(HttpServletRequest request,ModelMap model)
	 {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Account account = new Account(username, password);
		AccountDao acD = new AccountDao();
		try {
			if (acD.check(account) > 0) {
			 return "redirect:/ListSinhVien";
			
			} else {
				model.addAttribute("thongbaodnsai","Sai tên tài khoản hoặc mật khẩu !");
				return "DangNhap";
			}
		} catch (Exception e) {
			return "DangNhap";
		}
	}
}
