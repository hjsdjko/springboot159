package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TushurukuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TushurukuView;


/**
 * 图书入库
 *
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
public interface TushurukuService extends IService<TushurukuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushurukuView> selectListView(Wrapper<TushurukuEntity> wrapper);
   	
   	TushurukuView selectView(@Param("ew") Wrapper<TushurukuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushurukuEntity> wrapper);
   	

}

