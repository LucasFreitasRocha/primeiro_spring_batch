package com.crs.settings;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ParImparBatchSetting {
	@Autowired private JobBuilderFactory jobBuilderFactory;
	@Autowired private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job imprimeParImparJob() {
		return jobBuilderFactory.get("imprimeParImparJob").start(ImprimeParImparSetp())
				.incrementer(new RunIdIncrementer())
				.build();
	}

	private Step ImprimeParImparSetp() {
		// TODO Auto-generated method stub
		return stepBuilderFactory
				.get("ImprimeParImparSetp")
				.<Integer,String>chunk(1)
				.reader(contaAteDezReader())
				.processor(parouImparProcessor())
				.writer(imprimeWriter())
				.build();
	}

	private ItemWriter<? super String> imprimeWriter() {
		return itens -> itens.forEach(System.out::println);
	}

	private FunctionItemProcessor<Integer, String> parouImparProcessor() {
		
		return new FunctionItemProcessor<Integer, String>(
				item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é impar", item)
				);
	}

	private IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numerosDeUmAteDez = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(numerosDeUmAteDez);
	}

}
