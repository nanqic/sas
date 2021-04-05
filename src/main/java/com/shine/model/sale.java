package com.shine.model;

import java.io.Serializable;

public class sale implements Serializable {
    private Integer id;

    private Integer pid;

    private String area;

    private Integer saled;

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

    public String getArea() {
        return area;
    }

    public sale withArea(String area) {
        this.setArea(area);
        return this;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getSaled() {
        return saled;
    }

    public sale withSaled(Integer saled) {
        this.setSaled(saled);
        return this;
    }

    public void setSaled(Integer saled) {
        this.saled = saled;
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
        sb.append(", area=").append(area);
        sb.append(", saled=").append(saled);
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
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getSaled() == null ? other.getSaled() == null : this.getSaled().equals(other.getSaled()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getSaled() == null) ? 0 : getSaled().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        return result;
    }
}