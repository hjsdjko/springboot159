package com.cl.dao;

import com.cl.entity.TushuchukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuchukuView;


/**
 * 图书出库
 * 
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
public interface TushuchukuDao extends BaseMapper<TushuchukuEntity> {
	
	List<TushuchukuView> selectListView(@Param("ew") Wrapper<TushuchukuEntity> wrapper);

	List<TushuchukuView> selectListView(Pagination page,@Param("ew") Wrapper<TushuchukuEntity> wrapper);
	
	TushuchukuView selectView(@Param("ew") Wrapper<TushuchukuEntity> wrapper);
	

}
