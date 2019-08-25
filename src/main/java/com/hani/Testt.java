package com.hani;

import com.hani.controller.console.CommonController;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/12 下午10:01.
 * </pre>
 */
public class Testt {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        String startQueryTime = DateFormatUtils.format(new Timestamp(now - (30 * 24 * 3600 * 1000L)), "yyyy-MM-dd") + " 00:00:00";
        System.out.println(startQueryTime);

    }
}
