package com.amaduse.workflow_project;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowProjectApplicationTests {

    //测试用例中，进行环境初始操作
    @Test
    public void contextLoads() {

        int touHigh = 6;
        int jianHigh = 25 ;
        int kuang =50;
        for (int i=1;i<=touHigh+jianHigh;i++){
            for(int j =1;j<=kuang;j++){
                //上三角
                if (i<=touHigh) {
                    if(j>=(kuang/2+1)+1-i && j<=(kuang/2+1)-1+i){
                        System.out.print("*");
                    }else{
                        System.out.print("-");
                    }
                }
                //上三角一下部分
                if (i>touHigh&&i<=jianHigh){
                    if(j>=(kuang/2+1)+2-i&&j<=kuang-3*(i-touHigh)){
                        System.out.print("*");
                    }
                    else if(j<(kuang/2+1)-3+i&&j>=3*(i-touHigh)){
                        System.out.print("*");
                    }
                    else {
                        System.out.print("-");
                    }
                }
            }
            System.out.println("");
        }

    }

    @Value("${dbdriver}")
    private String driver ;
    @Value("${dburl}")
    private String url;
    @Value("${dbusername}")
    private String username;
    @Value("${dbpassword}")
    private String password;
    /**
     * activiti 检查创建所用25张表创建
     * 注意 重新创建时 需要删除序列 ACT_EVT_LOG_SEQ
     */
    @Test
    public void generate() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration()
                .setJdbcDriver(driver)
                .setJdbcUrl(url)
                .setJdbcUsername(username)
                .setJdbcPassword(password)
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        /**
         * public static final String DB_SCHEMA_UPDATE_FALSE ="false";不能自动创建表，需要表存在 public static final String
         * DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表 public static
         * final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        // 工作流的核心对象，ProcessEnginee对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println("processEngine:" + processEngine);
    }
}
