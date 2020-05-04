package dsa.grupo2.util;

import java.lang.reflect.Field;

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
                sb.append(", ?");
            }
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Class cl) {
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
        sb.append(" WHERE ID = ?");
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
                sb.append(", ").append(field).append("=? ");
            }
        }
        sb.append("WHERE ID = ?");

        return sb.toString();
    }

}
