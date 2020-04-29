package dsa.grupo2.util;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) {
        String objectName = object.getClass().getName();
        String method = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);;
        Object result = null;
        try {
            Class c = Class.forName(objectName);
            Method m = c.getDeclaredMethod(method);
            result = m.invoke(object,value);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static Object getter(Object object, String property) {

        String objectName = object.getClass().getName();
        String method = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);;
        Object result = null;
        try {
            Class c = Class.forName(objectName);
            Method m = c.getDeclaredMethod(method);
            result = m.invoke(object);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return  result;


    }
}
