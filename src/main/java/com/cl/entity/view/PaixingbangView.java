package com.cl.entity.view;

import com.cl.entity.PaixingbangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 排行榜
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 11:20:58
 */
@TableName("paixingbang")
public class PaixingbangView  extends PaixingbangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PaixingbangView(){
	}
 
 	public PaixingbangView(PaixingbangEntity paixingbangEntity){
 	try {
			BeanUtils.copyProperties(this, paixingbangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
