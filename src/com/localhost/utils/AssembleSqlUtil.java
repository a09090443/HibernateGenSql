package com.localhost.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Column;
import javax.persistence.Table;

public class AssembleSqlUtil {

	private static String columns = "";
	private static String values = "";

	public static String assembleInsertSql(Object obj, Boolean isReturn)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> c = obj.getClass();
		for (Method method : c.getDeclaredMethods()) {
			String name = method.getName();
			String methodType = method.getReturnType().getSimpleName();
			if (name.startsWith("get")) {
				if (method != null) {
					Column anno = method.getAnnotation(Column.class);
					if (methodType.toLowerCase().equals("string")) {
						columns = columns + "'" + anno.name() + "',";
						values = values + "'" + method.invoke(obj).toString() + "',";
					} else if (methodType.toLowerCase().equals("integer") || methodType.equals("int")) {
						columns = columns + "'" + anno.name() + "',";
						values = values + method.invoke(obj).toString() + ",";
					} else if (methodType.toLowerCase().equals("boolean")) {
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
		columns = columns.substring(0, columns.length() - 1);
		values = values.substring(0, values.length() - 1);
		return "INSERT INTO " + table.name() + "(" + columns + ") VALUES (" + values + ");";
	}
}
