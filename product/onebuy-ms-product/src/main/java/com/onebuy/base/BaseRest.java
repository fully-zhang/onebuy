package com.onebuy.base;

import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRest<D extends BaseEntity, S extends BaseService<D>> {

	protected BaseService<D> bService;

	protected abstract void setService(S service);

	@GetMapping(value = "/{id}")
	public D get(@PathVariable("id") final String id) {
		final D d = bService.get(id);
		return d;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public D create(@RequestBody final D d) {
		return bService.save(d);
	}

	@PutMapping(value = "/{id}")
	public D update(@PathVariable("id") final String id, @RequestBody final D d) {
		d.setId(id);
		return bService.update(d);
	}

	@PutMapping(value = "/{id}/delete")
	public D delUpdate(@PathVariable("id") final String id) {
		return bService.deleteUpdate(id);
	}

	@GetMapping
	public PageInfo<D> findAll(@RequestParam(defaultValue = "0", required = false) final Integer page,
                               @RequestParam(defaultValue = "30", required = false) final Integer size) {
		Map<String, Object> params = new HashMap(){{
            put("page", page);
            put("size", size);
        }};
		return bService.findAll(params);
	}

}
