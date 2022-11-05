package User.Dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import User.Domain.Friend;
import User.Domain.User;
import JDBC.Utils.DBUtils;

public class UserDao {
	//通过用户userid获取用户信息
	public User getUserById(String userId) throws ClassNotFoundException, SQLException {
		User user = new User();
		Connection conn = DBUtils.getConnection();
		String sql = "select * from user where userid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(userId));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setUserID(rs.getInt("userid"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setPhoneID(rs.getString("phoneid"));
			user.setEmail(rs.getString("email"));
		}

		return user;
	}

	// 得到所有用户
	public ArrayList<User> geAllUser() throws ClassNotFoundException, SQLException {
		ArrayList<User> userList = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		String sql = "select * from user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			User user = new User();
			user.setUserID(rs.getInt("userid"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setPhoneID(rs.getString("phoneid"));
			user.setEmail(rs.getString("email"));

			userList.add(user);
		}
		return userList;
	}

	// 通过username 获取userid
	public int getUserIdByUserName(User user) throws SQLException, ClassNotFoundException {
		int userid = 0;
		Connection conn = DBUtils.getConnection();

		String sql = "select * from user where username=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			userid = rs.getInt("userid");
		}
		return userid;
	}

	// 登陆验证
	public boolean Login(String username, String password){

		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user";

		try {
			conn = DBUtils.getConnection();
			if (conn != null)
			{
				//System.out.println("数据库连接正常");
			}
			else
			{
				//System.out.println("数据库连接异常");
			}
			pstmt = (PreparedStatement)conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 得到查询结果集

			while (rs.next())
			{
				String userName = rs.getString("username");
				String passWord = rs.getString("password");

				//System.out.println("数据库取得用户密码为"+userName + "密码为" + passWord);

				if(userName.equals(username) && passWord.equals(password))
				{
					returnValue = true;
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(rs,pstmt,conn);
		}
		return returnValue;
	}

	public void add(User user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into user (username,password,phoneid,email) values(?,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getPhoneID() );
			pstmt.setString(4,user.getEmail());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(pstmt,conn);
		}
	}

	// 修改 user
	public void modify(User user)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update user set username = ?,password = ?,phoneid = ?,email= ? where userid = ?";
		try {

			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUserName());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getPhoneID());
			pstmt.setString(4,user.getEmail());
			pstmt.setInt(5,user.getUserID());
			pstmt.executeUpdate();

			//System.out.println("Sql: " + sql);
		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		} finally {
			DBUtils.release(pstmt,conn);
		}
	}
	// 删除 user  注意级联删除外键
	public  void detele(int id)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 删除两个表中相同的数据
			String sql = "delete user,friends from user left join friends on user.userid = friends.userid where user.userid = ?";
			//System.out.println("sql:" + sql );
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException throwables) {
			throwables.printStackTrace();
		} finally {
			DBUtils.release(pstmt,conn);
		}
	}
	public ResultSet selectUser(String username) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from user where username=?";
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;

	}
}
