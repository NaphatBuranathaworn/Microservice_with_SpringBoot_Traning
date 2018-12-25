package com.business.order.item;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SaleOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date date;
    private String status;
    private String promotion;
    private Double subnet;
    private Double discount;
    private Double net;

    @OneToMany(mappedBy="saleOrder", cascade=CascadeType.ALL)
    private Set<Item> item;

    public SaleOrder(Long id, Date date, String status, String promotion, Double subnet, Double discount, Double net, Set<Item> item) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.promotion = promotion;
        this.subnet = subnet;
        this.discount = discount;
        this.net = net;
        this.item = item;
    }

    public SaleOrder() {
    }
       

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPromotion() {
        return this.promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Double getSubnet() {
        return this.subnet;
    }

    public void setSubnet(Double subnet) {
        this.subnet = subnet;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getNet() {
        return this.net;
    }

    public void setNet(Double net) {
        this.net = net;
    }

    public Set<Item> getItem() {
        return this.item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }
}