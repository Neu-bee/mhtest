package servlets;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*T用来确定集合中放什么类型的对象*/
public class BaseDao<T> {
	/*
	 * rs:结果集，封装了我们需要封装的数据
	 * clazz:方便使用反射会的类内部的信息
	 * */
	public List<T> getList(ResultSet rs, Class<T> clazz) throws SQLException, InstantiationException, 

IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		List<T> l=new ArrayList<T>();
		//结果集的元数据（包含了结果集的一些说明和定义信息）
		ResultSetMetaData metaData=rs.getMetaData();
		//遍历结果集，每循环一次，会读出一行数据
	    while(rs.next()){
	    	//obj为要封装的实体类对象
	    	T obj=clazz.newInstance();
	    	/*遍历行中的每一列*/
	        for(int i=1;i<=metaData.getColumnCount();i++){
	        	System.out.println("列的数量---------"+metaData.getColumnCount());
	        	
	        	//获得每一列的列名：goods_id
	        	String columnName=metaData.getColumnName(i);
	        	//根据列名拼接set方法:setGoods_id
	        	String setMethodName="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
	        	//得到每一列的数据类型名称：INT|CHAR|VARCHAR
	        	String typeName=metaData.getColumnTypeName(i);
	        	//根据列名以及列的数据类型得到对应的set方法
	        	Method thod=null;
	        	if(typeName.equals("INT")){
	        		thod=clazz.getDeclaredMethod(setMethodName, int.class);
	        	}
	        	else if(typeName.equals("CHAR")||typeName.equals("VARCHAR")){
	        		thod=clazz.getDeclaredMethod(setMethodName, String.class);
	        	}
	        	else if(typeName.equals("FLOAT")){
	        		thod=clazz.getDeclaredMethod(setMethodName, float.class);
	        	}
	        	else if(typeName.equalsIgnoreCase("Date")||typeName.equalsIgnoreCase("Datetime")){
	        		thod=clazz.getDeclaredMethod(setMethodName, Date.class);
	        	}
	        	//得到结果集中每一列的值：001
	        	Object value=rs.getObject(columnName);
//	        	System.out.println(value);
//	        	System.out.println(thod);
	            //调用obj对象的set方法，value为方法的实参
	        	thod.invoke(obj, value);
	        }
	         //将对象放入集合
	        l.add(obj);
	    }
		return l;
	}
	
}
