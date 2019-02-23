package com.classm.system.dao;

import com.classm.system.domain.GoodsTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author hw
 * @email hw@test.com
 * @date 2019-02-23 15:32:24
 */
@Mapper
public interface GoodsTypeDao {

	GoodsTypeDO get(Integer id);
	
	List<GoodsTypeDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsTypeDO goodsType);
	
	int update(GoodsTypeDO goodsType);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
