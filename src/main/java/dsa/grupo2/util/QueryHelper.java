package dsa.grupo2.util;

import java.lang.reflect.Field;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        for (String field: fields) {
            if (field == "id") {
                sb.append(field);
            }
            else {
                sb.append(", ").append(field);
            }
        }

        sb.append(") VALUES (");
        boolean first = true;

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

}
