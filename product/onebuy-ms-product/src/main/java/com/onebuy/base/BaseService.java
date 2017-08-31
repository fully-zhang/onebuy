package com.onebuy.base;

import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface BaseService<D extends BaseEntity> {

	PageInfo<D> findAll(Map<String, Object> map);

	D get(String id);

	D deleteUpdate(String id);

	D update(D obj);

	D save(D obj);

}
