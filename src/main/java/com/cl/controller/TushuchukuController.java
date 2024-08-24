package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.TushuchukuEntity;
import com.cl.entity.view.TushuchukuView;

import com.cl.service.TushuchukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书出库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
@RestController
@RequestMapping("/tushuchuku")
public class TushuchukuController {
    @Autowired
    private TushuchukuService tushuchukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushuchukuEntity tushuchuku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			tushuchuku.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushuchukuEntity> ew = new EntityWrapper<TushuchukuEntity>();

		PageUtils page = tushuchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuchuku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushuchukuEntity tushuchuku, 
		HttpServletRequest request){
        EntityWrapper<TushuchukuEntity> ew = new EntityWrapper<TushuchukuEntity>();

		PageUtils page = tushuchukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuchuku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushuchukuEntity tushuchuku){
       	EntityWrapper<TushuchukuEntity> ew = new EntityWrapper<TushuchukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuchuku, "tushuchuku")); 
        return R.ok().put("data", tushuchukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushuchukuEntity tushuchuku){
        EntityWrapper< TushuchukuEntity> ew = new EntityWrapper< TushuchukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuchuku, "tushuchuku")); 
		TushuchukuView tushuchukuView =  tushuchukuService.selectView(ew);
		return R.ok("查询图书出库成功").put("data", tushuchukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushuchukuEntity tushuchuku = tushuchukuService.selectById(id);
		tushuchuku = tushuchukuService.selectView(new EntityWrapper<TushuchukuEntity>().eq("id", id));
        return R.ok().put("data", tushuchuku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushuchukuEntity tushuchuku = tushuchukuService.selectById(id);
		tushuchuku = tushuchukuService.selectView(new EntityWrapper<TushuchukuEntity>().eq("id", id));
        return R.ok().put("data", tushuchuku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushuchukuEntity tushuchuku, HttpServletRequest request){
    	tushuchuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuchuku);
        tushuchukuService.insert(tushuchuku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushuchukuEntity tushuchuku, HttpServletRequest request){
    	tushuchuku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuchuku);
        tushuchukuService.insert(tushuchuku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushuchukuEntity tushuchuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuchuku);
        tushuchukuService.updateById(tushuchuku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushuchukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
