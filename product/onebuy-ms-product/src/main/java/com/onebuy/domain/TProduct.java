package com.onebuy.domain;

import com.onebuy.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class TProduct extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8943077842505653805L;

    private String productName;

    private String productTypeId;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", productName=").append(productName);
        sb.append(", productTypeId=").append(productTypeId);
        sb.append(", createdTime=").append(super.getCreatedTime());
        sb.append(", updatedTime=").append(super.getUpdatedTime());
        sb.append(", status=").append(super.getStatus());
        sb.append(", desc=").append(super.getDesc());
        sb.append("]");
        return sb.toString();
    }
}