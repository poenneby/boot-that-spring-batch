package com.onneby;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class LoadContactsJobConfiguration {
    @Bean
    public Job loadContactsJob(JobBuilderFactory jobFactory, Step loadStep) {
        return jobFactory.get("loadContactsJob").flow(loadStep).end().build();
    }
}
