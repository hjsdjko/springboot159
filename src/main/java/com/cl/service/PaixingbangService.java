package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PaixingbangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PaixingbangView;


/**
 * 排行榜
 *
 * @author 
 * @email 
 * @date 2024-03-18 11:20:58
 */
public interface PaixingbangService extends IService<PaixingbangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaixingbangView> selectListView(Wrapper<PaixingbangEntity> wrapper);
   	
   	PaixingbangView selectView(@Param("ew") Wrapper<PaixingbangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaixingbangEntity> wrapper);
   	

}

