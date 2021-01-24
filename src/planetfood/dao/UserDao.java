/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.EmpPojo;
import planetfood.pojo.User;

/**
 *
 * @author user
 */
public class UserDao {
    public static String validateUser(User user)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="Select username from Users where userid=? and password=? and usertype=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        
        ResultSet rs=ps.executeQuery();
        String username=null;
        
        if(rs.next())
        {
            username=rs.getString(1);
        }
        return username;
        
        
    }
    public static ArrayList<User> getUser()throws SQLException{
         Connection conn=DBConnection.getConnection();
          String qry="select * from users";     
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
          ArrayList<User> userList=new ArrayList<>();
          
          while(rs.next()){
              User p=new User();
              p.setUserId(rs.getString("userid"));
              p.setPassword(rs.getString("password"));
              p.setUserType(rs.getString("usertype"));
              p.setEmpId(rs.getString("empid"));
              p.setUserName(rs.getString("username"));
              userList.add(p);
          }
          return userList;
    }
     public static boolean deleteCashier(String id)throws SQLException{
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("delete from users where userid=?");
      ps.setString(1, id);
      int x=ps.executeUpdate();
      return(x>0);
      
  }
     
     public static boolean registerCashier(User p)throws SQLException{
         Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
      ps.setString(1,p.getUserId());
      ps.setString(2,p.getUserName());
      ps.setString(3,p.getEmpId() );
      ps.setString(4, p.getPassword());
      ps.setString(5,p.getUserType());
      
      int ans=ps.executeUpdate();
        return(ans>0);
     }
}


