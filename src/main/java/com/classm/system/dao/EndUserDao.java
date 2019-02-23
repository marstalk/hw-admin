package com.classm.system.dao;

import com.classm.system.domain.EndUserDO;

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
public interface EndUserDao {

	EndUserDO get(Integer id);
	
	List<EndUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(EndUserDO endUser);
	
	int update(EndUserDO endUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
