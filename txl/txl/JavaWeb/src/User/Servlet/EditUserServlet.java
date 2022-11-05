package User.Servlet;

import User.Dao.FriendDao;
import User.Dao.UserDao;
import User.Domain.Friend;
import User.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class EditFriendServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
		response.setCharacterEncoding("utf-8"); // 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 获取用户传过来的 friend
		UserDao userDao = new UserDao();
		try {
			User user = userDao.getUserById(request.getParameter("userid"));

			String username = request.getParameter("username");
			String phoneid = request.getParameter("phoneid");
			String password = request.getParameter("password");
			String email = request.getParameter("email");

			user.setUserName(username);
			user.setPhoneID(phoneid);
			user.setPassword(password);
			user.setEmail(email);

			userDao.modify(user);

			ArrayList<User> usersList = userDao.geAllUser();

			request.getSession().setAttribute("usersList",usersList);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("admin_index.jsp").forward(request,response);
	}
}
