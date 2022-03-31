package micro.doris.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import micro.doris.entity.Category;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "product", schema = "public")
public class ProductModel {

    @JsonProperty("rut")
    private Long id;

    @JsonProperty("rut")
    private String brand;

    @JsonProperty("rut")
    private String description;

    @JsonProperty("rut")
    private String stock;

    @JsonProperty("rut")
    private Date ingressdate;

    @JsonProperty("rut")
    private Date outgress;

    @JsonProperty("rut")
    private String active;

    @JsonProperty("rut")
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory")
    private Category category;


    public ProductModel(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category idcategory) {
        this.category = category;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStock() {
        return this.stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getIngressdate() {
        return this.ingressdate;
    }

    public void setIngressdate(java.sql.Date ingressdate) {
        this.ingressdate = ingressdate;
    }

    public Date getOutgress() {
        return this.outgress;
    }

    public void setOutgress(java.sql.Date outgress) {
        this.outgress = outgress;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
