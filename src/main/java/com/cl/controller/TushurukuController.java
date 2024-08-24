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

import com.cl.entity.TushurukuEntity;
import com.cl.entity.view.TushurukuView;

import com.cl.service.TushurukuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书入库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
@RestController
@RequestMapping("/tushuruku")
public class TushurukuController {
    @Autowired
    private TushurukuService tushurukuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushurukuEntity tushuruku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			tushuruku.setShangjiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushurukuEntity> ew = new EntityWrapper<TushurukuEntity>();

		PageUtils page = tushurukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuruku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushurukuEntity tushuruku, 
		HttpServletRequest request){
        EntityWrapper<TushurukuEntity> ew = new EntityWrapper<TushurukuEntity>();

		PageUtils page = tushurukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushuruku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushurukuEntity tushuruku){
       	EntityWrapper<TushurukuEntity> ew = new EntityWrapper<TushurukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushuruku, "tushuruku")); 
        return R.ok().put("data", tushurukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushurukuEntity tushuruku){
        EntityWrapper< TushurukuEntity> ew = new EntityWrapper< TushurukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushuruku, "tushuruku")); 
		TushurukuView tushurukuView =  tushurukuService.selectView(ew);
		return R.ok("查询图书入库成功").put("data", tushurukuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushurukuEntity tushuruku = tushurukuService.selectById(id);
		tushuruku = tushurukuService.selectView(new EntityWrapper<TushurukuEntity>().eq("id", id));
        return R.ok().put("data", tushuruku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushurukuEntity tushuruku = tushurukuService.selectById(id);
		tushuruku = tushurukuService.selectView(new EntityWrapper<TushurukuEntity>().eq("id", id));
        return R.ok().put("data", tushuruku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushurukuEntity tushuruku, HttpServletRequest request){
    	tushuruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuruku);
        tushurukuService.insert(tushuruku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushurukuEntity tushuruku, HttpServletRequest request){
    	tushuruku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tushuruku);
        tushurukuService.insert(tushuruku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushurukuEntity tushuruku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushuruku);
        tushurukuService.updateById(tushuruku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushurukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
