package User.Servlet;

import User.Domain.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 用户注销
		//取得登录的用户名
		HttpSession session =request.getSession();
		//销毁session
		session.invalidate();
		//给名为SINSESSION的cookie复写，将cookie的生命周期设置为0，相当于从客户端销毁了cookie
		Cookie cookie = new Cookie("SESSION","");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		//把复写的cookie返回给客户端
		response.addCookie(cookie);

		response.sendRedirect(request.getContextPath()+"/main.jsp");
	}
}
