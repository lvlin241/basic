package com.lxh.util;


import java.util.*;

/**
 * Map ������
 */
public class MapUtil {

    /**
     * ��ȡ����map�й�ͬ��key
     * @param map1 ����1
     * @param map2 ����2
     * @return ����map�й�ͬ��key�б�
     */
    private static List<String> diffCommonKey (Map<String,Integer> map1, Map<String,Integer> map2){
        if ( null == map1 || null == map2 )
            return null;
        List<String> res = new ArrayList<String>(10);
        Iterator<String> it1 = map1.keySet().iterator();
        Iterator<String> it2 = map2.keySet().iterator();
        while ( it1.hasNext() ){
            String k1 = it1.next();
            if ( map2.containsKey(k1) ){
                continue;
            }
            res.add(k1);
        }
        while ( it2.hasNext() ){
            String k2 = it2.next();
            if ( map1.containsKey(k2) ){
                continue;
            }
            res.add(k2);
        }
        return res;
    }
    /**
     * �ϲ� map
     * @param map1 ����1
     * @param map2 ����2
     * @return �ϲ����map
     */
    private static Map<String,Integer> addMap(Map<String,Integer> map1,Map<String,Integer> map2){
        Map<String,Integer> res = new HashMap<String,Integer>(1);
        if ( null == map1 && null == map2 ){
            return res;
        }

        if (null == map1){
            return map2;
        }

        if ( null == map2 ){
            return map1;
        }

        Set<String> key1 = map1.keySet();
        for (String k : key1) {
            if (map2.containsKey(k)) {
                res.put(k, map1.get(k) + map2.get(k));
            }
        }
        List<String> diffKey = diffCommonKey(map1,map2);
        if ( null == diffKey || 0 == diffKey.size() )
            return res;
        String tmp;
        for (String aDiffKey : diffKey) {
            tmp = aDiffKey;
            if (map1.containsKey(tmp))
                res.put(tmp, map1.get(tmp));
            if (map2.containsKey(tmp))
                res.put(tmp, map2.get(tmp));
        }
        return res;
    }

    public static void main(String[] args){
        Map<String,Integer> map1 = new HashMap<String,Integer>(3);
        map1.put("a",1);
        map1.put("b",2);
        map1.put("c",3);
        Map<String,Integer> map2 = new HashMap<String,Integer>(3);
        map2.put("a",11);
        map2.put("d",44);
        System.out.println(diffCommonKey(map1,map2).toString());
        Map<String,Integer> map = addMap(map1,map2);
        System.out.println(map);
    }
}