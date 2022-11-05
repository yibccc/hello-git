package User.Servlet;

import User.Dao.FriendDao;
import User.Dao.UserDao;
import User.Domain.Friend;
import User.Domain.User;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFriendServlet
 */
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendServlet() {
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
		Friend friend = new Friend();
		FriendDao friendDao = new FriendDao();
		UserDao userDao = new UserDao();

		// 得到当前页面 user
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

			friendDao.add(friend);

		} catch (SQLException | ClassNotFoundException | ParseException throwables) {
			throwables.printStackTrace();
		}
		//System.out.println("添加成功");
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
