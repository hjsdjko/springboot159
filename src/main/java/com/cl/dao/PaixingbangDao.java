package com.cl.dao;

import com.cl.entity.PaixingbangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaixingbangView;


/**
 * 排行榜
 * 
 * @author 
 * @email 
 * @date 2024-03-18 11:20:58
 */
public interface PaixingbangDao extends BaseMapper<PaixingbangEntity> {
	
	List<PaixingbangView> selectListView(@Param("ew") Wrapper<PaixingbangEntity> wrapper);

	List<PaixingbangView> selectListView(Pagination page,@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	
	PaixingbangView selectView(@Param("ew") Wrapper<PaixingbangEntity> wrapper);
	

}
