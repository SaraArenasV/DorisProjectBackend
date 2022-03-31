package micro.doris.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private String stock;

    @Column(name = "ingressdate")
    private Date ingressdate;

    @Column(name = "outgress")
    private Date outgress;

    @Column(name = "active")
    private String active;

    @Column(name = "sku")
    private String sku;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategory")
    private Category category;


    public Product(Category category) {
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
