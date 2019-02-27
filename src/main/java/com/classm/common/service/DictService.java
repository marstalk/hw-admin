package com.classm.common.service;

import com.classm.common.domain.DictDO;
import com.classm.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 * 
 * @author
 * @email
 * @date 2017-09-29 18:28:07
 */
public interface DictService {
	
	DictDO get(Long id);
	
	List<DictDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DictDO dict);
	
	int update(DictDO dict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<DictDO> listType();
	
	String getName(String type,String value);

	/**
	 * Get: 爱好列表
	 * @return
     * @param userDO
	 */
	List<DictDO> getHobbyList(UserDO userDO);

	/**
	 * Get: 性别列表
 	 * @return
	 */
	List<DictDO> getSexList();

	/**
	 * 根据typeGet: 数据
	 * @param map
	 * @return
	 */
	List<DictDO> listByType(String type);

}
