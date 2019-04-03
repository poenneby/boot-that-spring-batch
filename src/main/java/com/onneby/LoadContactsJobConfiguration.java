package com.onneby;

import com.onneby.model.DestinationContact;
import com.onneby.model.SourceContact;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class LoadContactsJobConfiguration {
    @Bean
    Job loadContactsJob(JobBuilderFactory jobFactory, Step loadStep) {
        return jobFactory.get("loadContactsJob").flow(loadStep).end().build();
    }

    @Bean
    Step loadStep(StepBuilderFactory stepBuilderFactory, ItemReader<SourceContact> contactReader, ItemProcessor<SourceContact, DestinationContact> contactProcessor, ItemWriter<DestinationContact> contactWriter) {
        return stepBuilderFactory.get("loadStep")
                .<SourceContact, DestinationContact>chunk(10)
                .reader(contactReader)
                .processor(contactProcessor)
                .writer(contactWriter)
                .build();
    }

    @Bean
    ItemReader<SourceContact> contactItemReader() {
        return new ContactReader();
    }

    @Bean
    ItemProcessor<SourceContact, DestinationContact> contactItemProcessor() {
        return new ContactProcessor();
    }

    @Bean
    ItemWriter<DestinationContact> contactWriter() {
        return new ContactWriter();
    }


}
