package User.Servlet;

import User.Dao.FriendDao;
import User.Dao.UserDao;
import User.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Servlet implementation class DeletFriendServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8"); // 设置编码格式
		request.setCharacterEncoding("utf-8");
		// 获取用户传过来的 friendid
		int id = Integer.parseInt(request.getParameter("userid"));

		UserDao userDao = new UserDao();
		userDao.detele(id);

		request.getRequestDispatcher("admin_index.jsp").forward(request,response);

		ArrayList<User> usersList = null;
		try {
			usersList = userDao.geAllUser();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.getSession().setAttribute("usersList",usersList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
	}

}
