package com.amaduse.workflow_project.common.generator.servcieImpl;

import com.amaduse.workflow_project.common.generator.servcie.ActivitiGeneratorService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Project Name : workflow_project</p>
 * <p>Activiti 启动初始化配置</p>
 * <p>Create Date : 2019/9/16 11:28</p>
 * <p>Create User : xin.zheng</p>
 */
@Transactional
@Service("ActivitiGeneratorService")
public class ActivitiGeneratorServiceImpl implements ActivitiGeneratorService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    ActivitiGeneratorServiceImpl() {
        logger.info("ActivitiGenerator Start");
    }

    @Value("${dbdriver}")
    private String driver ;
    @Value("${dburl}")
    private String url;
    @Value("${dbusername}")
    private String username;
    @Value("${dbpassword}")
    private String password;

    public void databaseGenerator(){
        logger.info("databaseGenerator Start");

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
        logger.info("processEngine:" + processEngine);
        logger.info("databaseGenerator End");
    }
}
