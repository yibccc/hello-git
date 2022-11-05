package User.Dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import JDBC.Utils.DBUtils;
import User.Domain.Friend;

public class FriendDao {

	//通过用户userid获取朋友信息
	public ArrayList<Friend> getFriendsById(int userId) throws ClassNotFoundException, SQLException {
		ArrayList<Friend> friendlist = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		String sql = "select * from friends where userid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Friend f = new Friend();
			f.setFriendID(rs.getInt("friendid"));
			f.setUserID(rs.getInt("userid"));
			f.setPhoneID(rs.getString("phoneid"));
			f.setFriendName(rs.getString("friendname"));
			f.setEmail(rs.getString("email"));
			f.setQQ(rs.getString("qq"));
			f.setCreateDate(rs.getDate("createdate"));
			friendlist.add(f);
		}		
		return friendlist;
	}

	// 根据条件查找满足要求的friend
	public ArrayList<Friend> serchFriendByCondition(Friend friend) throws SQLException, ClassNotFoundException {
		ArrayList<Friend> friendlist = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		String sql = "select * from friends where userid = ?";

		String friendname = friend.getFriendName();
		String phoneid = friend.getPhoneID();
		String qq = friend.getQQ();
		String email = friend.getEmail();

		//System.out.println("Friendname: "+friendname + "Phoneid: " + phoneid);
		//System.out.println("QQ: "+ qq + "Email: " + email);
		ArrayList<String> parm = new ArrayList<>();

		if(friendname != "")
		{
			sql += " and friendname = ?";
			parm.add(friendname);
		}
		if(phoneid != "")
		{
			sql += " and phoneid = ?";
			parm.add(phoneid);
		}
		if(qq != "")
		{
			sql += " and qq = ?";
			parm.add(qq);
		}
		if(email != "")
		{
			sql += " and email = ?";
			parm.add(email);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,friend.getUserID());

		//System.out.println("Length: " + parm.size());
		for (int i = 0; i < parm.size(); i++)
		{
			pstmt.setString(i+2,parm.get(i));
		}
		//System.out.println("Sql: " + sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Friend f = new Friend();
			f.setFriendID(rs.getInt("friendid"));
			f.setUserID(rs.getInt("userid"));
			f.setPhoneID(rs.getString("phoneid"));
			f.setFriendName(rs.getString("friendname"));
			f.setEmail(rs.getString("email"));
			f.setQQ(rs.getString("qq"));
			f.setCreateDate(rs.getDate("createdate"));
			friendlist.add(f);
		}
		return friendlist;
	}

	// 根据friendid 查找frend
	public Friend getFriendById(String friendid) throws ClassNotFoundException, SQLException {
		Friend f = new Friend();
		Connection conn = DBUtils.getConnection();
		String sql = "select * from friends where friendid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(friendid));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			f = new Friend();
			f.setFriendID(rs.getInt("friendid"));
			f.setUserID(rs.getInt("userid"));
			f.setPhoneID(rs.getString("phoneid"));
			f.setFriendName(rs.getString("friendname"));
			f.setEmail(rs.getString("email"));
			f.setQQ(rs.getString("qq"));
			f.setCreateDate(rs.getDate("createdate"));

		}
		return f;
	}

	// 增加friend
	public void add(Friend friend) throws ParseException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 获取当前时间
		java.util.Date date = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(date);

		java.util.Date dateTmp = new java.sql.Date(format.parse(dateStr).getTime());

		String sql = "insert into friends(friendid,userid,phoneid,friendname,email,qq,createdate) values(?,?,?,?,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1,friend.getFriendID());
			pstmt.setInt(2,friend.getUserID());
			pstmt.setString(3,friend.getPhoneID());
			pstmt.setString(4,friend.getFriendName());
			pstmt.setString(5,friend.getEmail());
			pstmt.setString(6,friend.getQQ());
			pstmt.setDate(7, new java.sql.Date(dateTmp.getTime()));
			pstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(pstmt,conn);
		}
	}

	// 删除 friend
	public  void detele(int id)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from friends where friendid = ?";
		try {
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

	// 修改 friend
	public void modify(Friend friend)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update friends set friendname = ?,phoneid = ?,qq = ?,email= ?,createdate = ? where friendid = ?";
		try {
			// 获取当前时间
			java.util.Date date = new java.util.Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = format.format(date);
			java.util.Date dateTmp = new java.sql.Date(format.parse(dateStr).getTime());

			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,friend.getFriendName());
			pstmt.setString(2,friend.getPhoneID());
			pstmt.setString(3,friend.getQQ());
			pstmt.setString(4,friend.getEmail());
			pstmt.setDate(5, new java.sql.Date(dateTmp.getTime()));
			pstmt.setInt(6,friend.getFriendID());
			pstmt.executeUpdate();

		//	System.out.println("Sql: " + sql);
		} catch (SQLException | ClassNotFoundException | ParseException throwables) {
			throwables.printStackTrace();
		} finally {
			DBUtils.release(pstmt,conn);
		}
	}
}
