package com.weimob.arch.demo.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

public class DemoUtil {

	 /**
     * 集合属性转换
     * 
     * @param srcList
     * @param c
     * @return
     */
	public static <S,T> List<T> copyList(Collection<S> srcList,Class<T> c){
		List<T> targetList = null;
		try{
			if(CollectionUtils.isNotEmpty(srcList)){
				targetList = new ArrayList<>();
				T t = null;
				for(S s : srcList){
					t = c.newInstance();
					BeanUtils.copyProperties(s, t);
					targetList.add(t);
				}
			}
		}catch(Exception e){
			throw new RuntimeException("转换bean出错", e);
		}
		return targetList;
	}
}
