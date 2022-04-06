package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class ProductModel {

    @JsonProperty("sku")
    private String sku;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("description")
    private String description;
    @JsonProperty("stock")
    private Integer stock;
    private java.sql.Date ingressDate;
    private java.sql.Date outgress;
    private int idCategory;
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Date getIngressDate() {
        return ingressDate;
    }

    public void setIngressDate(Date ingressDate) {
        this.ingressDate = ingressDate;
    }

    public Date getOutgress() {
        return outgress;
    }

    public void setOutgress(Date outgress) {
        this.outgress = outgress;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public ProductModel(String sku, String brand, String description, int stock, Date ingressDate, Date outgress, int idCategory){
        super();
        this.sku=sku;
        this.brand=brand;
        this.stock=stock;
        this.description=description;
        this.ingressDate=ingressDate;
        this.outgress=outgress;
        this.idCategory= idCategory;
    }
}
