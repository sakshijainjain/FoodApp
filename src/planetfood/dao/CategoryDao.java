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
import java.util.HashMap;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.CategoryPojo;

/**
 *
 * @author user
 */
public class CategoryDao {
    public static HashMap<String,String> getAllCategories()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select CAT_NAME,CAT_ID from categories");
        HashMap<String,String>categories=new HashMap<>();
        while(rs.next()){
            String catName=rs.getString(1);
            String catId=rs.getString(2);
            categories.put(catName,catId);
        
    }
        return categories;
    
}
     public static String getNewID()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement s=conn.createStatement();
        int id=101;
        ResultSet rs=s.executeQuery("select count(*) from categories");
       if(rs.next()){
           id=id+rs.getInt(1);
       }
        return "C"+id;
    }
     public static boolean addCategory(CategoryPojo p)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into categories values(?,?)");
        ps.setString(1, p.getCatId());
        ps.setString(2, p.getCatName());
        int ans=ps.executeUpdate();
        return(ans>0);
                       
    }
     public static boolean updateProduct(CategoryPojo p)throws SQLException{
       Connection conn=DBConnection.getConnection();
       String qry="update categories set cat_name=? where cat_id=?";
       
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, p.getCatName());
       ps.setString(2, p.getCatId());
      
       int x=ps.executeUpdate();
       return (x!=0);
   }
     
}
    
