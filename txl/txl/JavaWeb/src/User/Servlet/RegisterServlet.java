package User.Servlet;

import User.Dao.UserDao;
import User.Domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8"); // 设置编码格式
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneid = request.getParameter("phoneid");
        String email = request.getParameter("email");

        UserDao userDao = new UserDao();
        ResultSet rs = userDao.selectUser(username);
        try {
            if(rs.next()) {
                if (username.equals(rs.getString("username"))) {
                    request.setAttribute("nameRegisterError", "用户名已经存在!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("username", username);
                User user = new User();
                user.setUserName(username);
                user.setPassword(password);
                user.setPhoneID(phoneid);
                user.setEmail(email);
                userDao.add(user);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
