package com.crs.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crs.tasklet.ImprimeOlaTasklet;

@EnableBatchProcessing
@Configuration
public class ImprimeOlaStepConfig {


	@Autowired private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step imprimeOlaSetp( ImprimeOlaTasklet imprimeOlaTasklet) {
		// TODO Auto-generated method stub
		return stepBuilderFactory
				.get("imprimeOlaSetp")
				.tasklet(imprimeOlaTasklet).build();
		}
}
	

