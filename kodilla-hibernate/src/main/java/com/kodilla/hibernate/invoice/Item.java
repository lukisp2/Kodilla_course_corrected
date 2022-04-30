package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ITEMS")
public class Item {

    private int id;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;
    private List<Product> productList = new ArrayList<>();


    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity) {
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ITEM_ID")
    public int getId() {
        return id;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return price.multiply(new BigDecimal(quantity));
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "item",
            fetch = FetchType.LAZY)
    public List<Product> getProductList() {
        return productList;
    }

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


}
