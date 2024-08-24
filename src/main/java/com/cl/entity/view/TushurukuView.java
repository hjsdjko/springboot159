package com.cl.entity.view;

import com.cl.entity.TushurukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 图书入库
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 11:20:57
 */
@TableName("tushuruku")
public class TushurukuView  extends TushurukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushurukuView(){
	}
 
 	public TushurukuView(TushurukuEntity tushurukuEntity){
 	try {
			BeanUtils.copyProperties(this, tushurukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
