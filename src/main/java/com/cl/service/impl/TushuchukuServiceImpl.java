package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.TushuchukuDao;
import com.cl.entity.TushuchukuEntity;
import com.cl.service.TushuchukuService;
import com.cl.entity.view.TushuchukuView;

@Service("tushuchukuService")
public class TushuchukuServiceImpl extends ServiceImpl<TushuchukuDao, TushuchukuEntity> implements TushuchukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushuchukuEntity> page = this.selectPage(
                new Query<TushuchukuEntity>(params).getPage(),
                new EntityWrapper<TushuchukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushuchukuEntity> wrapper) {
		  Page<TushuchukuView> page =new Query<TushuchukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TushuchukuView> selectListView(Wrapper<TushuchukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushuchukuView selectView(Wrapper<TushuchukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
