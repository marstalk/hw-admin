package com.classm.common.service;

import org.springframework.stereotype.Service;

import com.classm.common.domain.LogDO;
import com.classm.common.domain.PageDO;
import com.classm.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
