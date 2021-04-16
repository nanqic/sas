package com.shine.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String name;

    private Integer price;

    private Byte sortId;

    private String img;

    private String describes;

    private Boolean onSale;

    private Date orderTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Product withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product withName(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public Product withPrice(Integer price) {
        this.setPrice(price);
        return this;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Byte getSortId() {
        return sortId;
    }

    public Product withSortId(Byte sortId) {
        this.setSortId(sortId);
        return this;
    }

    public void setSortId(Byte sortId) {
        this.sortId = sortId;
    }

    public String getImg() {
        return img;
    }

    public Product withImg(String img) {
        this.setImg(img);
        return this;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescribes() {
        return describes;
    }

    public Product withDescribes(String describes) {
        this.setDescribes(describes);
        return this;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public Product withOnSale(Boolean onSale) {
        this.setOnSale(onSale);
        return this;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public Product withOrderTime(Date orderTime) {
        this.setOrderTime(orderTime);
        return this;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", sortId=").append(sortId);
        sb.append(", img=").append(img);
        sb.append(", describes=").append(describes);
        sb.append(", onSale=").append(onSale);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getSortId() == null ? other.getSortId() == null : this.getSortId().equals(other.getSortId()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getDescribes() == null ? other.getDescribes() == null : this.getDescribes().equals(other.getDescribes()))
            && (this.getOnSale() == null ? other.getOnSale() == null : this.getOnSale().equals(other.getOnSale()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getSortId() == null) ? 0 : getSortId().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getDescribes() == null) ? 0 : getDescribes().hashCode());
        result = prime * result + ((getOnSale() == null) ? 0 : getOnSale().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        return result;
    }
}