package com.onebuy.util;



import com.onebuy.vo.RestResponse;

import java.util.HashMap;
import java.util.Map;

public class RestResponseUtils {

	public static final RestResponse success(final String msg, final Object content, final String detail) {
		return new RestResponse("000", msg, content, detail);
	}

	public static final RestResponse error(final String msg, final Object content, final String detail) {
		return new RestResponse("400", "错误", content, detail);
	}

	public static final RestResponse response(final String code, final String msg, final Object content,
			final String detail) {
		return new RestResponse(code, msg, content, detail);
	}
	
	public static final RestResponse success(final String keyName, final Object entity) {
		Map<String,Object> map=new HashMap<>();
		map.put(keyName, entity);
		final RestResponse response = new RestResponse("操作成功", "000",map, "操作成功");
		return response;
	}

}
