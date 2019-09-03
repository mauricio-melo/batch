package com.mm.batch.config;

import com.mm.batch.domain.Person;
import com.mm.batch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private final PersonRepository personRepository;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println(this.personRepository.findAll());
		}
	}
}