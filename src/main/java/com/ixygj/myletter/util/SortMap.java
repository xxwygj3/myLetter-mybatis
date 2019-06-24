package com.ixygj.myletter.util;

import java.util.Map;
import java.util.TreeMap;

public class SortMap{
    //自定义排序方法，返回有序map
    public static Map<String, Integer> sortMapByKey(Map<String, Integer> linkedHashMap) {
        Map<String, Integer> treeMap = new TreeMap<>(new MapKeyComparator());
        treeMap.putAll(linkedHashMap);
        return treeMap;
    }
}
