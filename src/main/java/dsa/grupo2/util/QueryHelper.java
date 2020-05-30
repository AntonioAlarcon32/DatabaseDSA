package dsa.grupo2.util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);
        boolean first = true;
        for (String field: fields) {
            if (first) {
                sb.append(field);
                first = false;
            }
            else {
                sb.append(", ").append(field);
            }
        }

        sb.append(") VALUES (");

        first = true;

        for (String field: fields) {
            if (first) {
                sb.append("?");
                first = false;
            }
            else {
                if (field.equals("password"))
                    sb.append(", MD5(?)");
                else
                    sb.append(", ?");
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Class cl, String searchField) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        Field[] fields = cl.getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            if (first) {
                sb.append(field.getName());
                first = false;
            }
            else {
                sb.append(",").append(field.getName());
            }
        }
        sb.append(" FROM ").append(cl.getSimpleName());
        sb.append(" WHERE ").append(searchField).append("= ?");
        return sb.toString();

    }

    public static String createQueryUPDATE(Object entity) {
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("SET ");
        String[] fields = ObjectHelper.getFields(entity);
        boolean first = true;
        for (String field : fields) {
            if (first) {
                sb.append(field);
                sb.append("=?");
                first = false;
            } else {
                if (field.equals("password")) {
                    sb.append(", ").append(field).append("=MD5(?) ");
                }
                else {
                    sb.append(", ").append(field).append("=? ");

                }
            }
        }
        sb.append("WHERE ID = ?");

        return sb.toString();
    }

    public static String createQueryCOUNT(Class cl, HashMap params) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT COUNT(*) ").append(" FROM ").append(cl.getSimpleName());
        sb.append(" WHERE ");

        boolean first = true;
        for (Field field : cl.getDeclaredFields()) {
            if (first) {
                if (params.containsKey(field.getName())) {
                    sb.append(field.getName()).append(" = ?");
                    first = false;
                }

            }
            else {
                if (params.containsKey(field.getName())) {
                    if ( field.getName().equals("password"))
                        sb.append(" AND ").append(field.getName()).append(" = MD5(?)");
                    else
                        sb.append(" AND ").append(field.getName()).append(" = ?");
                }
            }
        }
        return  sb.toString();
    }

    public static String createQueryFindAll(Class cl, HashMap params) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        Field[] fields = cl.getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            if (first) {
                sb.append(field.getName());
                first = false;
            }
            else {
                sb.append(",").append(field.getName());
            }
        }
        sb.append(" FROM ").append(cl.getSimpleName());
        sb.append(" WHERE ");
        first = true;
        for (Field field : fields) {
            if (first) {
                if (params.containsKey(field.getName())) {
                    sb.append(field.getName()).append(" = ?");
                    first = false;
                }

            }
            else {
                if (params.containsKey(field.getName())) {
                    if ( field.getName().equals("password"))
                        sb.append(" AND ").append(field.getName()).append(" = MD5(?)");
                    else
                        sb.append(" AND ").append(field.getName()).append(" = ?");
                }
            }
        }
        return  sb.toString();
    }
}
