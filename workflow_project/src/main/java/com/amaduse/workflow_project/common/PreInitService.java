package com.amaduse.workflow_project.common;

import com.amaduse.workflow_project.common.generator.servcie.ActivitiGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>Project Name : workflow_project</p>
 *
 * <p>Create Date : 2019/9/16 11:27</p>
 * <p>Create User : xin.zheng</p>
 */
@Component
public class PreInitService implements CommandLineRunner {
    final private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("ActivitiGeneratorService")
    ActivitiGeneratorService activitiGenerator;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("PreInitService doing !!!");
        activitiGenerator.databaseGenerator();
    }
}
