package com;

import java.lang.reflect.Field;
import java.util.HashMap;

public class ClassUtil {
	static public HashMap<String, Object> getObjSnapshot(Object obj) throws Exception{
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	System.out.println(obj.getClass().getTypeName());
    	for (Class<?> c = obj.getClass(); c != null; c = c.getSuperclass())
        {
    		if(c.getName().equals("java.lang.Object")){
    			break;
    		}
    		
            Field[] fields = c.getDeclaredFields();
            for (Field classField : fields)
            {
            	if(!classField.isAccessible()){
            		classField.setAccessible(true);
            	}
            	
            	String key = c.getTypeName()+"_"+classField.getName();
            	Object val = classField.get(obj);
				String type = classField.getType().getSimpleName();
            	
            	if(val != null){
            		map.put(key, val);
            		System.out.println(key+" " +type+" field Makes. = "+val);
            	}
            }
        }
    	
    	return map;
    	
    }
}
