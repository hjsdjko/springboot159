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

import com.cl.entity.PaixingbangEntity;
import com.cl.entity.view.PaixingbangView;

import com.cl.service.PaixingbangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 排行榜
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 11:20:58
 */
@RestController
@RequestMapping("/paixingbang")
public class PaixingbangController {
    @Autowired
    private PaixingbangService paixingbangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaixingbangEntity paixingbang,
		HttpServletRequest request){
        EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();

		PageUtils page = paixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paixingbang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaixingbangEntity paixingbang, 
		HttpServletRequest request){
        EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();

		PageUtils page = paixingbangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paixingbang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaixingbangEntity paixingbang){
       	EntityWrapper<PaixingbangEntity> ew = new EntityWrapper<PaixingbangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paixingbang, "paixingbang")); 
        return R.ok().put("data", paixingbangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaixingbangEntity paixingbang){
        EntityWrapper< PaixingbangEntity> ew = new EntityWrapper< PaixingbangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paixingbang, "paixingbang")); 
		PaixingbangView paixingbangView =  paixingbangService.selectView(ew);
		return R.ok("查询排行榜成功").put("data", paixingbangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaixingbangEntity paixingbang = paixingbangService.selectById(id);
		paixingbang = paixingbangService.selectView(new EntityWrapper<PaixingbangEntity>().eq("id", id));
        return R.ok().put("data", paixingbang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaixingbangEntity paixingbang = paixingbangService.selectById(id);
		paixingbang = paixingbangService.selectView(new EntityWrapper<PaixingbangEntity>().eq("id", id));
        return R.ok().put("data", paixingbang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
    	paixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paixingbang);
        paixingbangService.insert(paixingbang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
    	paixingbang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(paixingbang);
        paixingbangService.insert(paixingbang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaixingbangEntity paixingbang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paixingbang);
        paixingbangService.updateById(paixingbang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paixingbangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
