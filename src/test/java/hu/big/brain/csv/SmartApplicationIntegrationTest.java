package hu.big.brain.csv;

import hu.big.brain.csv.config.DumpDataSourceConfiguration;
import hu.big.brain.csv.config.PrimaryDataSourceConfiguration;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@ContextConfiguration(classes = {SmartReaderApplication.class, SmartReaderJobConfiguration.class, PrimaryDataSourceConfiguration.class, DumpDataSourceConfiguration.class}, initializers = ConfigDataApplicationContextInitializer.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class SmartApplicationIntegrationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void test() throws Exception {
        runApplication();
    }

    private void runApplication() throws Exception {
        JobParameters jobParameters = jobLauncherTestUtils.getUniqueJobParameters();
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        Assertions.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }

}
