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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.OrderDetails;
import planetfood.pojo.OrderPojo;


public class OrderDao {
    public static ArrayList<OrderPojo> getOrderByDate(Date startDate,Date endDate)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from orders where ord_date between ? and ?");
        long ms1=startDate.getTime(); //conver date into mili sec
        long ms2=endDate.getTime();
        java.sql.Date sdate=new java.sql.Date(ms1);
        java.sql.Date edate=new java.sql.Date(ms2);
        ps.setDate(1, sdate);
        ps.setDate(2, edate);
        ResultSet rs=ps.executeQuery();
        ArrayList<OrderPojo> orderList=new ArrayList<OrderPojo>();
        while(rs.next()){
            OrderPojo obj=new OrderPojo();
            obj.setOrdId(rs.getString("ord_id"));
            java.sql.Date d=rs.getDate("ord_date");
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
            String datestr=sdf.format(d);
            obj.setOrdDate(datestr);
           obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserId(rs.getString("userid"));
           orderList.add(obj);
         }
        return orderList;
     }
    public static String getNewId()throws SQLException{
          Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select count(*) from orders");
        int id=101;
        ResultSet rs=ps.executeQuery();
        while(rs.next())
            id=id+rs.getInt(1);
        return "OD"+id;
    }
    public static boolean addOrder(OrderPojo order,ArrayList<OrderDetails> orderList)throws SQLException, ParseException{
Connection con=DBConnection.getConnection();
    PreparedStatement ps=con.prepareStatement("Insert into orders values(?,?,?,?,?,?,?,?)");
    ps.setString(1,order.getOrdId());
    String dateStr=order.getOrdDate();
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
    java.util.Date d1=sdf.parse(dateStr);
    java.sql.Date d2=new java.sql.Date(d1.getTime());
    ps.setDate(2, d2);
    ps.setDouble(3,order.getGst());
    ps.setDouble(4,order.getGstAmount());
    ps.setDouble(5,order.getDiscount());
    ps.setDouble(6,order.getGrandTotal());
    ps.setString(7,order.getUserId());
    ps.setDouble(8, order.getOrdAmount());
    int x=ps.executeUpdate();
    PreparedStatement ps2=con.prepareStatement("Insert into order_details values(?,?,?,?)");
    int count=0,y;
    
    for(OrderDetails detail:orderList){
    ps2.setString(1,detail.getOrdId());
ps2.setString(2,detail.getProdId()) ;
ps2.setDouble(3,detail.getQuantity());
ps2.setDouble(4,detail.getCost());
y=ps2.executeUpdate();
count=count+y;
    }
        System.out.println("toto");
    
    if(x>0 && count==orderList.size())
    return true;
    else
    return false;
    }
public static ArrayList<OrderPojo> getAllData()throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from orders";     
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<OrderPojo>ordList=new ArrayList<OrderPojo>();
          while(rs.next()){
            OrderPojo obj=new OrderPojo();
            obj.setOrdId(rs.getString("ord_id"));
            java.sql.Date d=rs.getDate("ord_date");
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
            String datestr=sdf.format(d);
            obj.setOrdDate(datestr);
           obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserId(rs.getString("userid"));
           ordList.add(obj);
         }
        return ordList;
  
   }
public static ArrayList<OrderPojo> getAllDataUID(String uid)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from orders where userid=?";     
        PreparedStatement st=conn.prepareStatement(qry);
        st.setString(1, uid);
        System.out.println(uid);
        ResultSet rs=st.executeQuery();
        ArrayList<OrderPojo>ordList=new ArrayList<OrderPojo>();
          while(rs.next()){
            OrderPojo obj=new OrderPojo();
            obj.setOrdId(rs.getString("ord_id"));
            java.sql.Date d=rs.getDate("ord_date");
            SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
            String datestr=sdf.format(d);
            obj.setOrdDate(datestr);
           obj.setOrdAmount(rs.getDouble("ord_amount"));
           obj.setGst(rs.getDouble("gst"));
           obj.setGstAmount(rs.getDouble("gst_amount"));
           obj.setGrandTotal(rs.getDouble("grand_total"));
           obj.setDiscount(rs.getDouble("discount"));
           obj.setUserId(uid);
           ordList.add(obj);
         }
        return ordList;
  
   }
}
