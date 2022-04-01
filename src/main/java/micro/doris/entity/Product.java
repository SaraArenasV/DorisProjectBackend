package micro.doris.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idcategory")
    private Integer idcategory;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "ingressdate")
    private java.sql.Date ingressdate;

    @Column(name = "outgress")
    private java.sql.Date outgress;

    @Column(name = "active")
    private String active;


    @Column(name = "sku")
    private String sku;

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
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

    public Date getIngressdate() {
        return ingressdate;
    }

    public void setIngressdate(Date ingressdate) {
        this.ingressdate = ingressdate;
    }

    public Date getOutgress() {
        return outgress;
    }

    public void setOutgress(Date outgress) {
        this.outgress = outgress;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
