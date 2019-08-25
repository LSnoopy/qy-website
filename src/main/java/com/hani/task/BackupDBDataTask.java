package com.hani.task;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 17/2/23 下午9:24.
 * </pre>
 */
@Component("backupDBDataTask")
public class BackupDBDataTask {

    private static final String TABLE_NEWS = "news";

    //"0 15 10 15 * ?" 每月15日上午10:15触发
    //0 18 22 * * ? 表示每天22点18分
//    @Scheduled(cron = "0 23 10 24 * ?")
    public void backupPer30DaysNewsData() throws Exception {
        String startQueryTime = DateFormatUtils.format(new Timestamp(System.currentTimeMillis() - (30 * 24 * 3600 * 1000L)), "yyyy-MM-dd") + " 00:00:00";
        String sql = "SELECT * FROM news WHERE create_time >= '" + startQueryTime + "' and remark NOT LIKE '%delFlag%' ORDER BY create_time DESC";
        backupDBData(sql, TABLE_NEWS);
    }

    public void backupAllNewsData() throws Exception {
        String sql = "SELECT * FROM news WHERE remark NOT LIKE '%delFlag%' ORDER BY create_time DESC";
        backupDBData(sql, TABLE_NEWS);
    }

    private void backupDBData(String sql, String tableName) throws Exception {
        final Date now = new Date();
        System.out.println(DateFormatUtils.format(now, "yyyy-MM-dd HH:mm:ss") + " 开始执行备份 " + tableName + " 表数据任务......");

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;

        WebApplicationContext wc = ContextLoader.getCurrentWebApplicationContext();
        ServletContext sc = wc.getServletContext();
        DataSource ds = (DataSource) wc.getBean("dataSource");
        conn = ds.getConnection();
        stat = conn.createStatement();

        StringBuilder sb = new StringBuilder(10);

        String relativePath = "backup/" + tableName + "/";
        String path = sc.getRealPath(relativePath);
        File parentFile = new File(path);
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        File targetFile = new File(parentFile, tableName + "-data-sql-" + DateFormatUtils.format(now, "yyyy-MM-dd") + ".sql");
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriterWithEncoding(targetFile, "UTF-8"));

        int count = 0;
        try {
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                Date cdate = rs.getDate("create_time");
                Date mdate = rs.getDate("modify_time");
                String createTime = cdate != null ? DateFormatUtils.format(cdate, "yyyy-MM-dd HH:mm:ss") : "1970-01-01 00:00;00";
                String modifyTime = mdate != null ? DateFormatUtils.format(mdate, "yyyy-MM-dd HH:mm:ss") : "1970-01-01 00:00;00";
                if ("news".equals(tableName)) {
                    sb.append("insert into news(type,title,content,top_flag,show_flag,create_time,modify_time,remark,source) values(")
                            .append(rs.getByte("type")).append(",'").append(rs.getString("title")).append("','")
                            .append(rs.getString("content")).append("',")
                            .append(rs.getByte("top_flag")).append(",").append(rs.getByte("show_flag"))
                            .append(",'").append(createTime).append("','")
                            .append(modifyTime).append("','").append(rs.getString("remark")).append("','")
                            .append(rs.getString("source")).append("');");
                }
                count++;
            }
            conn.close();
            stat.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNotBlank(sb.toString())) {
            bw.write(sb.toString());
        }
        bw.close();
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " 本次共计备份 " + tableName + " 表 " + count + " 条数据");
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " 结束执行备份 " + tableName + " 表数据任务......");
    }
}
