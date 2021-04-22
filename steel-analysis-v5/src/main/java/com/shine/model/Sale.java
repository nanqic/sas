package com.shine.model;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable {
    private Integer pid;

    private Byte rid;

    private Integer soldAmount;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public Sale withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Byte getRid() {
        return rid;
    }

    public Sale withRid(Byte rid) {
        this.setRid(rid);
        return this;
    }

    public void setRid(Byte rid) {
        this.rid = rid;
    }

    public Integer getSoldAmount() {
        return soldAmount;
    }

    public Sale withSoldAmount(Integer soldAmount) {
        this.setSoldAmount(soldAmount);
        return this;
    }

    public void setSoldAmount(Integer soldAmount) {
        this.soldAmount = soldAmount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Sale withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", rid=").append(rid);
        sb.append(", soldAmount=").append(soldAmount);
        sb.append(", updateTime=").append(updateTime);
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
        Sale other = (Sale) that;
        return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
            && (this.getSoldAmount() == null ? other.getSoldAmount() == null : this.getSoldAmount().equals(other.getSoldAmount()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getSoldAmount() == null) ? 0 : getSoldAmount().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}