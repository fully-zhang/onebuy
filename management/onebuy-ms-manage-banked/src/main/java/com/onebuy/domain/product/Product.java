package com.onebuy.domain.product;

import com.onebuy.domain.BaseEntity;
import com.onebuy.domain.EntityStatus;
import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 8943077842505653805L;

    @Parsed(field = "产品名称")
    private String productName;

    @Parsed(field = "产品类型ID")
    private String productTypeId;

    public Product() {
    }

    public Product(String productName, String productTypeId, boolean flag) {
        if (flag) {
            super.setCreatedTime(new Date());
            super.setUpdatedTime(new Date());
            super.setStatus(EntityStatus.NORMAL);
        } else {
            super.setUpdatedTime(new Date());
        }
        this.productName = productName;
        this.productTypeId = productTypeId;
    }

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