package com.hani.util;

import org.apache.commons.lang3.StringUtils;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/1/3 下午8:46.
 * </pre>
 */
public class FileUtil {
    public static String getFileSuffix(String fileName) {
        if (StringUtils.isNotBlank(fileName)) {
            return fileName.substring(fileName.indexOf("."), fileName.length());
        }
        return "";
    }

}
