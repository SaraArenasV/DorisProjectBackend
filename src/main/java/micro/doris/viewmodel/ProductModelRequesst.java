package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class ProductModelRequesst {

    @JsonProperty("sku")
    private String sku;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("description")
    private String description;
    @JsonProperty("stock")
    private Integer stock;
    @JsonProperty("idCategory")
    private Integer idCategory;


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

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }
}
