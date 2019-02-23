package com.classm.system.dao;

import com.classm.system.domain.GoodsPicDO;

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
public interface GoodsPicDao {

	GoodsPicDO get(Integer id);
	
	List<GoodsPicDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsPicDO goodsPic);
	
	int update(GoodsPicDO goodsPic);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
