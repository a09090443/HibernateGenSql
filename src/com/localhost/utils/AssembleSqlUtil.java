package com.localhost.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Column;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

public class AssembleSqlUtil {

	private static String columns = "";
	private static String values = "";

	public static String assembleInsertSql(Object obj, Boolean isReturn)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> c = obj.getClass();
		String value = "";
		for (Method method : c.getDeclaredMethods()) {
			String name = method.getName();
			String methodType = method.getReturnType().getSimpleName();
			if (name.startsWith("get")) {
				if (method != null) {
					Column anno = method.getAnnotation(Column.class);
					if(null != method.invoke(obj)){
						value = method.invoke(obj).toString();
					}else{
						value = "";
					}
					if (methodType.toLowerCase().equals("string")) {
						columns = columns + anno.name() + ",";
						if(anno.nullable() && StringUtils.isBlank(value)){
							values = values + "NULL,";
						}else{
							values = values + "'" + value + "',";
						}
					} else if (methodType.toLowerCase().equals("integer") || methodType.equals("int") || methodType.toLowerCase().equals("short") || methodType.toLowerCase().equals("byte")) {
						columns = columns + anno.name() + ",";
						if(StringUtils.isBlank(value)){
							values = values + "NULL,";
						}else{
							values = values + value + ",";
						}
					} else if (methodType.toLowerCase().equals("long")) {
						columns = columns + anno.name() + ",";
						values = values + value + ",";
					} else if (methodType.toLowerCase().equals("boolean")) {
						columns = columns + anno.name() + ",";
						if(StringUtils.isBlank(value)){
							values = values + "NULL,";
						}else{
							values = values + value + ",";
						}
					} else if (name.equals("getId")) {
						assembleInsertSql(method.invoke(obj), false);
					}

				}
			}
		}
		if (!isReturn) {
			return null;
		}
		Table table = c.getAnnotation(Table.class);
		String cols = columns.substring(0, columns.length() - 1);
		String vals = values.substring(0, values.length() - 1);
		columns = "";
		values = "";
		return "INSERT INTO " + table.name() + "(" + cols + ") VALUES (" + vals + ");";
	}
}
