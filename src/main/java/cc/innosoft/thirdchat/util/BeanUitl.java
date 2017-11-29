package cc.innosoft.thirdchat.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class BeanUitl {
	
	private static Logger logger = LoggerFactory.getLogger(BeanUitl.class);
	
	/**
	 * 属性copy
	 * @param dest 
	 * @param orig 来源
	 */
	public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			logger.error("属性拷贝异常",e);
		}
	}

	/**
	 * @方法名:transBean2Map
	 * @描述:bean转map
	 * @创建者:wk
	 * @创建时间:2017年5月23日 下午4:25:21
	 * @参数:@param obj
	 * @参数:@return
	 * @return:Map<String,Object>
	 */
	public static HashMap<String, Object> transBean2Map(Object obj) {
        if(obj == null){
            return null;
        }        
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }
}
