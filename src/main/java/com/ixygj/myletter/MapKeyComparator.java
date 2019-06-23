package com.ixygj.myletter;

import java.util.Comparator;

/**
 * 自定义比较器
 */
public class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str2.compareTo(str1);
    }
}
