package dsa.grupo2;

import dsa.grupo2.util.*;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            conn.close();
        }
        catch (Exception e) {
            //traza
        }

    }

    public Object get(Class theClass, String searchField, String value) {
        String getQuery = QueryHelper.createQuerySELECT(theClass, searchField);
        Object o = null;
        PreparedStatement pstm = null;

        try {
                pstm = conn.prepareStatement(getQuery);
                o = theClass.getDeclaredConstructor().newInstance();
                pstm.setObject(1, value);

                ResultSet rs = pstm.executeQuery();
                ResultSetMetaData data = rs.getMetaData();
                rs.next();
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    String columnName = data.getColumnName(i);
                    ObjectHelper.setter(o,columnName,rs.getObject(i));
                }
            }
            catch (Exception e) {
                return null;
            }
        return o;
    }

    public void update(Object newObject, String id) {
        String updateQuery = QueryHelper.createQueryUPDATE(newObject);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(updateQuery);
            int i = 1;

            for (String field: ObjectHelper.getFields(newObject)) {
                pstm.setObject(i++, ObjectHelper.getter(newObject, field));
            }

            pstm.setObject(i,ObjectHelper.getter(newObject,"id"));
            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Integer count(Class cl, HashMap params) {
        String countQuery = QueryHelper.createQueryCOUNT(cl,params);
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(countQuery);
            int i = 1;

            for(Field field : cl.getDeclaredFields()) {
                if (params.containsKey(field.getName()))
                    pstm.setObject(i++, params.get(field.getName()));
            }
            ResultSet rs = pstm.executeQuery();
            rs.next();
            Integer res = rs.getInt("COUNT(*)");
            return res;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {
        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
