package com.shine.model;

import java.io.Serializable;

public class sale implements Serializable {
    private Integer id;

    private Integer pid;

    private String province;

    private Integer sold;

    private Integer stock;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public sale withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public sale withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvince() {
        return province;
    }

    public sale withProvince(String province) {
        this.setProvince(province);
        return this;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getSold() {
        return sold;
    }

    public sale withSold(Integer sold) {
        this.setSold(sold);
        return this;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Integer getStock() {
        return stock;
    }

    public sale withStock(Integer stock) {
        this.setStock(stock);
        return this;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", province=").append(province);
        sb.append(", sold=").append(sold);
        sb.append(", stock=").append(stock);
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
        sale other = (sale) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getSold() == null ? other.getSold() == null : this.getSold().equals(other.getSold()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getSold() == null) ? 0 : getSold().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        return result;
    }
}