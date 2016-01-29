package com.app.mybatis.plugins.pagable;

import java.lang.reflect.Field;

public class ReflectHelper {

	private static Field getField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
				.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {
				if (clazz == Object.class) {
					e.printStackTrace();
				}
			}
		}
		return field;
	}

	public static Object getFieldValue(Object obj, String fieldName) {
		Object result = null;
		Field field = getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			try {
				result = field.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void setFieldValue(Object obj, String fieldName,
			String fieldValue) {
		Field field = getField(obj, fieldName);
		if (field != null) {
			try {
				field.setAccessible(true);
				field.set(obj, fieldValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
