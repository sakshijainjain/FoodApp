/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.pojo;


public class OrderDetails {
    private static String prodId;
    private static String ordId;
    private static double cost;
    private static double quantity;

    public static String getProdId() {
        return prodId;
    }

    public static void setProdId(String prodId) {
        OrderDetails.prodId = prodId;
    }

    public static String getOrdId() {
        return ordId;
    }

    public static void setOrdId(String ordId) {
        OrderDetails.ordId = ordId;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        OrderDetails.cost = cost;
    }

    public static double getQuantity() {
        return quantity;
    }

    public static void setQuantity(double quantity) {
        OrderDetails.quantity = quantity;
    }

    
}
