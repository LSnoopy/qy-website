package com.hani.datasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/19 下午9:24.
 * </pre>
 */
public class HaniDruidDataSource extends DruidDataSource {
    @Override
    public void setUsername(String username) {
        try {
            username = ConfigTools.decrypt(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(username);
    }
}
