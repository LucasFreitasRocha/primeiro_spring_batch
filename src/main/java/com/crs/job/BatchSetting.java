package com.crs.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchSetting {
	
	@Autowired private JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job impimeOlaJob(Step imprimeOlaStep) {
		return jobBuilderFactory
				.get("impimeOlaJob")
				.start(imprimeOlaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}

	
	/*@Bean
	@StepScope
	public Tasklet imprimeOlaTasklet(@Value("#{jobParameters['nome']}") String nome) {
		return new Tasklet() {
			
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				System.out.println(String.format("Olá %s!", nome));
				return RepeatStatus.FINISHED;
			}
		};
	} */

}
