package com.hogun.agv.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.hogun.agv.model.Person;

public class BeanUtil {

	public static void main(String[] args) {
		Person p = new Person("wgx", 12);
		System.out.println(getField(p, "name"));
		setField(p, "name", "hxj");
		System.out.println(getField(p, "name"));
	}

	/**
	 * 获取bean对象字段
	 * 
	 * @param bean
	 * @param fieldName
	 * @return
	 */
	public static String getField(Object bean, String fieldName) {
		try {
			return BeanUtils.getProperty(bean, fieldName);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 设置bean对象字段值
	 * 
	 * @param bean
	 * @param fieldName
	 * @param value
	 */
	public static void setField(Object bean, String fieldName, Object value) {
		try {
			BeanUtils.setProperty(bean, fieldName, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
