package micro.doris.to;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ProductCategory {

    public ProductCategory() {
    }

    private Integer id;

    private Integer idcategory;

    private String categoryName;

    private String brand;

    private String description;

    private Integer stock;

    private java.sql.Date ingressdate;

    private java.sql.Date outgress;

    private String active;

    private String sku;

    private String name;



    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Integer idcategory) {
        this.idcategory = idcategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

	public ProductCategory(Integer id, Integer idcategory, String categoryName, String brand, String description, Integer stock, Date ingressdate, Date outgress, String active, String sku, String name) {
		this.id = id;
		this.idcategory = idcategory;
		this.categoryName = categoryName;
		this.brand = brand;
		this.description = description;
		this.stock = stock;
		this.ingressdate = ingressdate;
		this.outgress = outgress;
		this.active = active;
		this.sku = sku;
		this.name = name;
	}


}
