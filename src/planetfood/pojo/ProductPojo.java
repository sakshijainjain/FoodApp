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
public class ProductPojo {
    private String prodid;
    private String catid;
    private String prodname;
    private Double prodprice;

    public Double getProdprice() {
        return prodprice;
    }

    public void setProdprice(Double prodprice) {
        this.prodprice = prodprice;
    }
    private String isActive;

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

   

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
    
}
