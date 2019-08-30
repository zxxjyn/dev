package com.amaduse.generate;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Component
@SpringBootTest
public class GenerateApplicationTests {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${dbdriver}")
    private String driver ;
    @Value("${dburl}")
    private String url;
    @Value("${dbusername}")
    private String username;
    @Value("${dbpassword}")
    private String password;

    @Before
    public void initTest(){
        logger.info("Test Start !!!");
    }

    @Test
    /**
     * activiti 25张表创建
     */
    public void generate() {
        logger.info("datasource init brfore");
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();

        // 连接数据库的配置
        // 配置数据库驱动:对应不同数据库类型的驱动
        processEngineConfiguration.setJdbcDriver(driver);

//        // 配置数据库的JDBC URL
        processEngineConfiguration
                .setJdbcUrl(url);
//        // 配置连接数据库的用户名
        processEngineConfiguration.setJdbcUsername(username);
//        // 配置连接数据库的密码
        processEngineConfiguration.setJdbcPassword(password);
        /**
         * public static final String DB_SCHEMA_UPDATE_FALSE =
         * "false";不能自动创建表，需要表存在 public static final String
         * DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表 public static
         * final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 工作流的核心对象，ProcessEnginee对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
    }

    @After
    public void end(){
        logger.debug(" This is debug!!!");
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.info("Test End !!!");
    }
}
