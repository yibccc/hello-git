package User.Servlet;

import User.Dao.AdminDao;
import User.Dao.UserDao;
import User.Domain.Admin;
import User.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class LoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8"); // 设置编码格式
		request.setCharacterEncoding("utf-8");

		// 获取用户名 密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session =request.getSession();

		AdminDao adminDao = new AdminDao();
		UserDao userDao =new UserDao();
		boolean canLogin = adminDao.Login(username,password); // 通过从jsp中获取username and password
		//System.out.println("username : " + username + "password: " + password);
		//System.out.println("登陆状态：" + canLogin);

		if (canLogin)
		{
			//登陆成功
			//将用户user存入session域
			Admin admin = new Admin();
			admin.setAdminName(username);
			admin.setPassword(password);


			try {
				ArrayList<User> usersList = userDao.geAllUser();

				request.getSession().setAttribute("usersList",usersList);

				request.getSession().setAttribute("admin",admin);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}


			Cookie cookie = new Cookie("SESSION",admin.getAdminName());
			//设置作用域，这里设置为根目录以下所有
			cookie.setPath("/");

			//将设置好的cookie保存到客户端的浏览器
			response.addCookie(cookie);

			// 跳转至首页
			request.getRequestDispatcher("admin_index.jsp").forward(request,response);
			//System.out.println("用户名密码正确");
		}
		else
		{
			session.invalidate();
			request.getRequestDispatcher("admin_login.jsp").forward(request,response);
			//System.out.println("用户名密码错误");
		}
	}
}
