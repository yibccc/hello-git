package User.Servlet;

import User.Dao.FriendDao;
import User.Domain.Friend;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFriendServlet
 */
public class EditFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFriendServlet() {
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
		FriendDao friendDao = new FriendDao();
		try {
			Friend friend = friendDao.getFriendById(request.getParameter("friendid"));

			String friendname = request.getParameter("friendname");
			String phoneid = request.getParameter("phoneid");
			String qq = request.getParameter("qq");
			String email = request.getParameter("email");

			friend.setFriendName(friendname);
			friend.setPhoneID(phoneid);
			friend.setQQ(qq);
			friend.setEmail(email);

			friendDao.modify(friend);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
