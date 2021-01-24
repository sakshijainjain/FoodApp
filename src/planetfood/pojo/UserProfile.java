/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.pojo;

/**
 *
 * @author user
 */
public class UserProfile {

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfile.userName = userName;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        UserProfile.userType = userType;
    }
    private static String userName;
    private static String userType;
    private static String userid;

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        UserProfile.userid = userid;
    }
    
}
