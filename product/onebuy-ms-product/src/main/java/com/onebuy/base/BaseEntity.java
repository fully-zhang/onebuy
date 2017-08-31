package com.onebuy.base;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhj on 2017/8/30.
 */

@Data
public class BaseEntity {

    /**
     * id
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * 状态
     */
    private EntityStatus status = EntityStatus.NORMAL;

    /**
     * 留用列
     */
    private String desc;

}
