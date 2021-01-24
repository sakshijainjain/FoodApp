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
import planetfood.pojo.EmpPojo;
import planetfood.pojo.ProductPojo;

/**
 *
 * @author user
 */
public class EmpDao {
      public static String getNewID()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement s=conn.createStatement();
        int id=101;
        ResultSet rs=s.executeQuery("select count(*) from Employee");
       if(rs.next()){
           id=id+rs.getInt(1);
       }
        return "E"+id;
    }
       public static boolean addEmp(EmpPojo p)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?)");
        ps.setString(1, p.getEmpId());
        ps.setString(2, p.getEmpName());
         ps.setString(3, p.getJob());
         ps.setString(4, p.getSalary());
        int ans=ps.executeUpdate();
        return(ans>0);
                       
    }
        public static HashMap<String,String> getAllIdJob()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select empid,job from Employee");
        HashMap<String,String>categories=new HashMap<>();
        while(rs.next()){
            String empid=rs.getString(1);
            String job=rs.getString(2);
            categories.put(empid,job);
        
    }
        return categories;
    
}
         public static ArrayList<String> getAllJob()throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select DISTINCT job from Employee");
        ArrayList<String>categories=new ArrayList<>();
        while(rs.next()){
            
            String job=rs.getString(1);
            categories.add(job);
        
    }
        return categories;
         
}
         public static ArrayList<EmpPojo> getAllData()throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from employee";     
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<EmpPojo>empList=new ArrayList<EmpPojo>();
          while(rs.next()){
            EmpPojo p=new EmpPojo();
            p.setEmpId(rs.getString("empid"));
            p.setEmpName(rs.getString("ename"));
            p.setJob(rs.getString("job"));
            p.setSalary(rs.getString("sal"));
           
            empList.add(p);
         }
        return empList;
  
   }
            public static ArrayList<EmpPojo> getAllDataById(String empid)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select * from employee where empid=?";     
        PreparedStatement st=conn.prepareStatement(qry);
        st.setString(1, empid);
        ResultSet rs=st.executeQuery();
        ArrayList<EmpPojo>empList=new ArrayList<EmpPojo>();
          while(rs.next()){
            EmpPojo p=new EmpPojo();
            p.setEmpId(empid);
            p.setEmpName(rs.getString("ename"));
            p.setJob(rs.getString("job"));
            p.setSalary(rs.getString("sal"));
           
            empList.add(p);
         }
        return empList;
  
   }
         
         public static boolean updateEmp(EmpPojo p)throws SQLException{
             Connection conn=DBConnection.getConnection();
             PreparedStatement ps=conn.prepareStatement("update employee set ename=?,job=?,sal=? where empid=?");
             ps.setString(1, p.getEmpName());
             ps.setString(2, p.getJob());
             ps.setString(3, p.getSalary());
             ps.setString(4, p.getEmpId());
             int x=ps.executeUpdate();
             return(x>0);
         }
  public static boolean deleteEmp(String id)throws SQLException{
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("delete from employee where empid=?");
      ps.setString(1, id);
      int x=ps.executeUpdate();
      return(x>0);
      
  }
  public static String getEmpNameById(String id)throws SQLException{
       Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select ename from employee where empid=?");
         ps.setString(1, id);
         String empName=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next()) 
             empName=rs.getString(1);
          
        return empName;
  }
       
}
