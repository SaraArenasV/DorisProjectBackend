package micro.doris.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "ingressdate")
    private Date ingressDate;

    @Column(name = "outgress")
    private Date outgress;

    @Column(name = "active")
    private String active;

    @Column(name = "idcategory")
    private int idCategory;
  //  @ManyToOne
    //@JoinColumn(name = "idCategory")
    //private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getOutgress() {
        return outgress;
    }

    public void setOutgress(Date outgress) {
        this.outgress = outgress;
    }

    public Date getIngressDate() {
        return ingressDate;
    }

    public void setIngressDate(Date ingressDate) {
        this.ingressDate = ingressDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    public Product(){

    }

    public Product(String sku, String brand, String description, int stock, Date ingressDate, Date outgress, int idCategory){
        super();
        this.sku=sku;
        this.brand=brand;
        this.stock=stock;
        this.description=description;
        this.ingressDate=ingressDate;
        this.outgress=outgress;
        this.active="a";
        this.idCategory= idCategory;
}
}
