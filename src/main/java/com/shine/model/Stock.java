package com.shine.model;

import java.io.Serializable;

public class Stock implements Serializable {
    private Integer id;

    private Integer pid;

    private Integer amount;

    private Byte regionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public Stock withId(Integer id) {
        this.setId(id);
        return this;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public Stock withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public Stock withAmount(Integer amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getRegionId() {
        return regionId;
    }

    public Stock withRegionId(Byte regionId) {
        this.setRegionId(regionId);
        return this;
    }

    public void setRegionId(Byte regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", amount=").append(amount);
        sb.append(", regionId=").append(regionId);
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
        Stock other = (Stock) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getRegionId() == null ? other.getRegionId() == null : this.getRegionId().equals(other.getRegionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getRegionId() == null) ? 0 : getRegionId().hashCode());
        return result;
    }
}