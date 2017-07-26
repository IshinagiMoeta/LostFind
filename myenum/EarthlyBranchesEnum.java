package com.whitesharkapps.lostfind.myenum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ketianxing on 2017/7/13.
 */

public interface EarthlyBranchesEnum {
    Map<Integer, String> eb = new HashMap<Integer, String>(){{
        put(1, "子");
        put(2, "丑");
        put(3, "寅");
        put(4, "卯");
        put(5, "辰");
        put(6, "巳");
        put(7, "午");
        put(8, "未");
        put(9, "申");
        put(10, "酉");
        put(11, "戌");
        put(12, "亥");

    }};
}
