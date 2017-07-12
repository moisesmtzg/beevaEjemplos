package com.beeva.SpringBatch.SpringBatch;


import javax.batch.operations.JobRestartException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("jobSimple.xml");
        JobLauncher jobLauncer =(JobLauncher)context.getBean("jobLauncher");
        Job job = (Job)context.getBean("processFileJob");
        try {
			JobExecution exe;
			try {
				exe = jobLauncer.run(job, new JobParameters());
				System.out.println("status " +exe.getStatus());
			} catch (org.springframework.batch.core.repository.JobRestartException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
