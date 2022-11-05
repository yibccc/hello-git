package User.Servlet;

import User.Dao.UserDao;
import User.Domain.User;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String remember = request.getParameter("remember");
		HttpSession session =request.getSession();

		//判断用户名、密码是否为空
		if(username==""||username.length()==0){
			request.setAttribute("namemsg","用户名为空!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if(password==""||password.length()==0) {
			request.setAttribute("pwdmsg", "密码为空!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		UserDao userDao = new UserDao();
		ResultSet rs = userDao.selectUser(username);
		try {
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					request.setAttribute("username",username);
					//登陆成功
					//将用户user存入session域
					User user = new User();
					user.setUserName(username);
					user.setPassword(password);
					request.getSession().setAttribute("user",user);
					Cookie cookie = new Cookie("SESSION",user.getUserName());
					//设置作用域，这里设置为根目录以下所有
					cookie.setPath("/");
					if("true".equals(remember)) {
						cookie.setMaxAge(7*24*60*60);
					}else{
						cookie.setMaxAge(24*60*60);
					}
					//将设置好的cookie保存到客户端的浏览器
					response.addCookie(cookie);
					// 跳转至首页
					request.getRequestDispatcher("index.jsp").forward(request,response);

				}else{
					request.setAttribute("pwdError","密码不正确!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("nameError","用户名不存在!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
