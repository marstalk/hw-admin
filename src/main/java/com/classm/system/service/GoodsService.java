package com.classm.system.service;

import com.classm.system.domain.GoodsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
public interface GoodsService {
	
	GoodsDO get(Integer id);
	
	List<GoodsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GoodsDO goods);
	
	int update(GoodsDO goods);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
