package db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author wangchong
 */
public class ConcatSql {

    public static void main(String[] args) {
        Map<String, String> parameterMap = new HashMap<>();
        Map<String, String> where = new HashMap<>();
        parameterMap.put("a", "111");
        parameterMap.put("b", "222");
        parameterMap.put("c", "333");
        where.put("cond1", "c1");
        where.put("cond2", "c2");
        StringBuilder sql = new StringBuilder("update test ");
        Set<Map.Entry<String, String>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String> next : entries) {
            sql.append(" ")
                    .append(next.getKey())
                    .append(" = ");
            if (next.getValue() != null && next.getValue() instanceof String) {
                sql.append("'");
            }
            sql.append(next.getValue());
            if (next.getValue() != null && next.getValue() instanceof String) {
                sql.append("'");
            }

                   sql.append(", ");
        }
        if (',' == sql.charAt(sql.length()-2)) {
            sql.replace(sql.length() -2, sql.length() - 1, "");
        }

        if (where.size() > 0) {
            sql.append(" where 1 = 1");

            Set<Map.Entry<String, String>> entries1 = where.entrySet();
            for (Map.Entry<String, String> w : entries1) {
                sql.append(" and ").append(w.getKey()).append(" = '").append(w.getValue()).append("' ");
            }
        }
        System.out.println(sql.toString());
    }
}
