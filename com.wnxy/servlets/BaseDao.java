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
/*T����ȷ�������з�ʲô���͵Ķ���*/
public class BaseDao<T> {
	/*
	 * rs:���������װ��������Ҫ��װ������
	 * clazz:����ʹ�÷��������ڲ�����Ϣ
	 * */
	public List<T> getList(ResultSet rs, Class<T> clazz) throws SQLException, InstantiationException, 

IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		List<T> l=new ArrayList<T>();
		//�������Ԫ���ݣ������˽������һЩ˵���Ͷ�����Ϣ��
		ResultSetMetaData metaData=rs.getMetaData();
		//�����������ÿѭ��һ�Σ������һ������
	    while(rs.next()){
	    	//objΪҪ��װ��ʵ�������
	    	T obj=clazz.newInstance();
	    	/*�������е�ÿһ��*/
	        for(int i=1;i<=metaData.getColumnCount();i++){
	        	System.out.println("�е�����---------"+metaData.getColumnCount());
	        	
	        	//���ÿһ�е�������goods_id
	        	String columnName=metaData.getColumnName(i);
	        	//��������ƴ��set����:setGoods_id
	        	String setMethodName="set"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
	        	//�õ�ÿһ�е������������ƣ�INT|CHAR|VARCHAR
	        	String typeName=metaData.getColumnTypeName(i);
	        	//���������Լ��е��������͵õ���Ӧ��set����
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
	        	//�õ��������ÿһ�е�ֵ��001
	        	Object value=rs.getObject(columnName);
//	        	System.out.println(value);
//	        	System.out.println(thod);
	            //����obj�����set������valueΪ������ʵ��
	        	thod.invoke(obj, value);
	        }
	         //��������뼯��
	        l.add(obj);
	    }
		return l;
	}
	
}
