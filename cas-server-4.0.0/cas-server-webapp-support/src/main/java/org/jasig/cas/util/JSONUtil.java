package org.jasig.cas.util;

import java.util.List;

import net.sf.json.JSONArray;

public class JSONUtil {
	/***
     * 将List对象序列化为JSON文本
     */
    public static <T> String toJSONString(List<T> list)
    {
        JSONArray jsonArray = JSONArray.fromObject(list);

        return jsonArray.toString();
    }
}
