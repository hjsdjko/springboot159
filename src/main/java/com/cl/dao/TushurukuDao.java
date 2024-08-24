package com.cl.dao;

import com.cl.entity.TushurukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushurukuView;


/**
 * 图书入库
 * 
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
public interface TushurukuDao extends BaseMapper<TushurukuEntity> {
	
	List<TushurukuView> selectListView(@Param("ew") Wrapper<TushurukuEntity> wrapper);

	List<TushurukuView> selectListView(Pagination page,@Param("ew") Wrapper<TushurukuEntity> wrapper);
	
	TushurukuView selectView(@Param("ew") Wrapper<TushurukuEntity> wrapper);
	

}
