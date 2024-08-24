package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushuchukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushuchukuView;


/**
 * 图书出库
 *
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
public interface TushuchukuService extends IService<TushuchukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushuchukuView> selectListView(Wrapper<TushuchukuEntity> wrapper);
   	
   	TushuchukuView selectView(@Param("ew") Wrapper<TushuchukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushuchukuEntity> wrapper);
   	

}

