package User.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import User.Dao.FriendDao;
import User.Dao.UserDao;
import User.Domain.Friend;
import User.Domain.User;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8"); // 设置编码格式
		request.setCharacterEncoding("utf-8");
		Friend friend = new Friend();
		FriendDao friendDao = new FriendDao();
		UserDao userDao = new UserDao();
		ArrayList<Friend> friendlist;
		User user = (User) request.getSession().getAttribute("user");

		try {
			int userid = userDao.getUserIdByUserName(user);

			String friendname = request.getParameter("friendname");
			String phoneid = request.getParameter("phoneid");
			String qq = request.getParameter("qq");
			String email = request.getParameter("email");

			friend.setUserID(userid);
			friend.setFriendName(friendname);
			friend.setPhoneID(phoneid);
			friend.setQQ(qq);
			friend.setEmail(email);

			friendlist = friendDao.serchFriendByCondition(friend);

			request.getSession().setAttribute("friendlist",friendlist);

			request.getRequestDispatcher("index.jsp").forward(request,response);

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		}

	}
}
