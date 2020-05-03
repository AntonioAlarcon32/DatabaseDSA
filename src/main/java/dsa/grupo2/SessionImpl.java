package dsa.grupo2;

import dsa.grupo2.util.*;

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

    }

    public Object get(Class theClass, String id) {
        String getQuery = QueryHelper.createQuerySELECT(theClass);
        Object o = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(getQuery);
            o = theClass.getDeclaredConstructor().newInstance();
            pstm.setObject(1, id);

            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData data = rs.getMetaData();
            rs.next();
            for (int i = 1; i <= data.getColumnCount(); i++) {
                String columnName = data.getColumnName(i);
                ObjectHelper.setter(o,columnName,rs.getObject(i));
            }


            }
            catch (Exception e) {
                e.printStackTrace();
            }

        return o;
    }

    public void update(Object object) {

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
