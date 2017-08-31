package com.onebuy.base;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Transactional
public abstract class BaseServiceImpl<D extends BaseEntity> implements BaseService<D> {
	protected String[] IGNORE = new String[] { "id", "createdTime" };

	protected String[] getIgnore() {
		return IGNORE;
	}

	protected abstract BaseDao<D, String> getDao();

    protected Class<D> entityClazz;

    @SuppressWarnings("unchecked")
    public BaseServiceImpl() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClazz = (Class<D>) params[0];
    }

	@Override
	public PageInfo<D> findAll(final Map<String, Object> page) {
		return new PageInfo<D>(getDao().findAll(page));
	}

	@Override
	public D get(final String id) {
		return getDao().selectByPrimaryKey(id);
	}

	@Override
	public D deleteUpdate(final String id) {
		final D d = get(id);
		//d.setStatus(EntityStatus.DELETED);
		return update(d);
	}

	@Override
	public D update(final D obj) {
		final D d = get(obj.getId());
		BeanUtils.copyProperties(obj, d, getIgnore());
        int primaryKey = getDao().updateByPrimaryKey(d);
        return primaryKey > 0 ? d : get(obj.getId());
	}

	@Override
	public D save(final D obj) {
        int insert = getDao().insert(obj);
        return insert > 0 ? obj : null;
	}

}
