package vn.hoidanit.laptopshop.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @OneToMany(mappedBy = "product")
    // List<OrderDetail> orderDetails;

    private String name;
    private double price;
    private String image;
    private String detaiDesc;
    private long quantity;
    private long sold;
    private String factory;
    private String target;

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetaiDesc() {
        return detaiDesc;
    }

    public void setDetaiDesc(String detaiDesc) {
        this.detaiDesc = detaiDesc;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

@Override
public String toString() {
return "Product [id=" + id + ", name=" + name + ", price=" + price + ",
image=" + image + ", detaiDesc="
+ detaiDesc + ", quantity=" + quantity + ", sold=" + sold + ", factory=" +
factory + ", target="
+ target + "]";
}

}
