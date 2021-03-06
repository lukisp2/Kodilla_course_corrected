package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;
import javax.persistence.*;


@Entity
@Table(name = "PRODUCTS")
public class Product {

    private int id;
    private String name;
    private Item item;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    public int getId() {
        return id;
    }

    @Column(name = "PRODUCT_NAME")
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
