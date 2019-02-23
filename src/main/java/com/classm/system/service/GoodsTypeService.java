package com.classm.system.service;

import com.classm.system.domain.GoodsTypeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
public interface GoodsTypeService {
	
	GoodsTypeDO get(Integer id);
	
	List<GoodsTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(GoodsTypeDO goodsType);
	
	int update(GoodsTypeDO goodsType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
