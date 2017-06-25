package com.localhost.base.dao;

import java.util.List;

public interface BaseDao<T> {
	public List<T> findAll() throws Exception;
}
