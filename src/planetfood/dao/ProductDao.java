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
import java.util.HashMap;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.ProductPojo;

/**
 *
 * @author user
 */
public class ProductDao {
    public static String getNewID()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement s=conn.createStatement();
        int id=101;
        ResultSet rs=s.executeQuery("select count(*) from products");
       if(rs.next()){
           id=id+rs.getInt(1);
       }
        return "P"+id;
    }
    public static boolean addProduct(ProductPojo p)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?)");
        ps.setString(1, p.getProdid());
        ps.setString(2, p.getCatid());
        ps.setString(3, p.getProdname());
        ps.setDouble(4, p.getProdprice());
        ps.setString(5, p.getIsActive());
        int ans=ps.executeUpdate();
        return(ans>0);
                       
    }
   public static HashMap<String,ProductPojo>getProductsByCategory(String catId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from Products where CAT_ID=?");
        HashMap<String,ProductPojo>productList=new HashMap<String,ProductPojo>();
        ps.setString(1, catId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            ProductPojo p=new ProductPojo();
            p.setCatid(catId);
            p.setProdid(rs.getString("PROD_ID"));
            p.setProdname(rs.getString("PROD_NAME"));
            p.setProdprice(rs.getDouble("PROD_PRIZE"));
            p.setIsActive(rs.getString("active"));
            productList.put(p.getProdid(),p);
         }
        return productList;
   }
   public static ArrayList<ProductPojo> getAllData()throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from products";     
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<ProductPojo>productList=new ArrayList<ProductPojo>();
          while(rs.next()){
            ProductPojo p=new ProductPojo();
            p.setCatid(rs.getString("cat_Id"));
            p.setProdid(rs.getString("PROD_ID"));
            p.setProdname(rs.getString("PROD_NAME"));
            p.setProdprice(rs.getDouble("PROD_PRIZE"));
            p.setIsActive(rs.getString("active"));
            productList.add(p);
         }
        return productList;
  
   }
   public static boolean updateProduct(ProductPojo p)throws SQLException{
       Connection conn=DBConnection.getConnection();
       String qry="update products set cat_id=?,prod_name=?,prod_prize=?,active=? where prod_id=?";
       
       PreparedStatement ps=conn.prepareStatement(qry);
       ps.setString(1, p.getCatid());
       ps.setString(2, p.getProdname());
       ps.setDouble(3,p.getProdprice());
       ps.setString(4, p.getIsActive());
       ps.setString(5, p.getProdid());
       int x=ps.executeUpdate();
       return (x!=0);
   }
   public static boolean removeProduct(String prodId)throws SQLException{
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("Update Products set active='N' where prod_id=?");
       ps.setString(1, prodId);
       int x=ps.executeUpdate();
       return (x!=0);
               
   }
}
