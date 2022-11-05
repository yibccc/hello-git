package User.Dao;

import JDBC.Utils.DBUtils;
import User.Domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    // 登陆验证
    public boolean Login(String username, String password){

        boolean returnValue = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from admin";

        //System.out.println("sql:" + sql);
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // 得到查询结果集

            while (rs.next())
            {
                String AdminName = rs.getString("username");
                String passWord = rs.getString("password");

                if(AdminName.equals(username) && passWord.equals(password))
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
}
