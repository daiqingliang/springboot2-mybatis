package com.daiql.mybatis.auto;

/**
 * @Description:
 * @Author: daiql
 * @CreateDate: 2019/4/15 8:37 PM
 * @Version: 1.0
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenerateService {

    private String url = "jdbc:mysql://127.0.0.1/plc?characterEncoding=utf8&useSSL=false";
    private String username = "root";
    private String password = "123456";
    private String driverClass = "com.mysql.cj.jdbc.Driver";
    private DatabaseMetaData dbMetaData = null;
    private String packageName = "com.daiql.mybatis.service;";
    private String packageNameDto = "com.daiql.mybatis.service";
    private String path = "/Users/xinxihua/Desktop/workspace/auto-generate-entity/src/main/java/com/daiql/mybatis/service/";

    public GenerateService() {
        try {
            Class.forName(driverClass);
            Connection conn = DriverManager.getConnection(url, username, password);
            dbMetaData = conn.getMetaData();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取所有的表
     * @author: ppt
     * @date: 2015-3-16 上午10:12:57
     * @return: void
     */
    public List<String> getAllTableList() {
        List<String> tableList = new ArrayList<String>();
        try {
            String[] types = { "TABLE" };
            ResultSet rs = dbMetaData.getTables(null, null, "%", types);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");  //表名
                tableList.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    /**
     * 处理字符串，去掉下划线“_”，并且把下划线的下一个字符变大写，flag为true，表示首字母要大写
     * @param name
     * @param flag
     * @return
     */
    private String getFormatString(String name, boolean flag) {
        name = name.toLowerCase();
        String[] nameTemp = name.split("_");
        StringBuffer buffer = new StringBuffer();
        for(String str : nameTemp) {
            String head = str.substring(0, 1).toUpperCase();
            String tail = str.substring(1);
            buffer.append(head+tail);
        }
        StringBuffer result = null;
        if(!flag) {
            result = new StringBuffer();
            String head = buffer.substring(0, 1).toLowerCase();
            String tail = buffer.substring(1);
            result.append(head+tail);
            return result.toString();
        }
        return buffer.toString();
    }
    /**
     * 把String内容写到文件
     * @param fileName
     * @param content
     */
    private void outputToFile(String fileName, String content) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(path+fileName);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        byte[] b = content.getBytes();
        try {
            os.write(b);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getService() {
        List<String> tableList = getAllTableList();
        for(String tableName : tableList) {
            String table = getFormatString(tableName, true);
            String className = table + "Service";
            StringBuffer sb = new StringBuffer();
            sb.append("package " + packageName + "\n\n");
            sb.append("import " + packageNameDto + "." + table + ";\n");
            sb.append("import java.util.List;\n");
            sb.append("import javax.ws.rs.POST;\n");
            sb.append("import javax.ws.rs.GET;\n");
            sb.append("import javax.ws.rs.PathParam;\n");
            sb.append("import javax.ws.rs.Path;\n");
            sb.append("import javax.ws.rs.Produces;\n");
            sb.append("import javax.ws.rs.core.MediaType;\n");
            sb.append("\n@Path(\"/" + className.substring(0, 1).toLowerCase() + className.substring(1) + "\")\n");
            sb.append("public interface " + className + " {\n\n");

            sb.append("\t//增加实体\n");
            sb.append("\t@POST\n");
            sb.append("\t@Path(\"addEntity\")\n");
            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
            sb.append("\tpublic long addEntity(" + table + " dto) throws Exception;\n\n");

            sb.append("\t//删除实体\n");
            sb.append("\t@GET\n");
            sb.append("\t@Path(\"deleteEntity/{id}\")\n");
            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
            sb.append("\tpublic boolean deleteEntity(@PathParam(\"id\") long id) throws Exception;\n\n");

            sb.append("\t//修改实体\n");
            sb.append("\t@POST\n");
            sb.append("\t@Path(\"updateEntity\")\n");
            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
            sb.append("\tpublic long updateEntity(" + table + " dto) throws Exception;\n\n");

            sb.append("\t//查询实体\n");
            sb.append("\t@POST\n");
            sb.append("\t@Path(\"findEntity\")\n");
            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
            sb.append("\tpublic "+table+" findEntity(" + table + " dto) throws Exception;\n\n");

            sb.append("\t//查询实体List\n");
            sb.append("\t@POST\n");
            sb.append("\t@Path(\"findEntityList\")\n");
            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
            sb.append("\tpublic List<"+table+"> findEntityList(" + table + " dto) throws Exception;\n\n");

            sb.append("}\n");
            outputToFile(className+".java", sb.toString());
        }
    }

    public static void main(String[] agrs) {
        GenerateService aa = new GenerateService();
        aa.getService();
    }

}