package hu.big.brain.csv;

import hu.big.brain.csv.config.BatchTestConfig;
import hu.big.brain.csv.config.DumpDataSourceConfiguration;
import hu.big.brain.csv.config.PrimaryDataSourceConfiguration;
import hu.big.brain.model.ListingStatus;
import hu.big.brain.model.Marketplace;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.batch.test.AssertFile.assertFileEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BatchTestConfig.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {SmartReaderApplication.class, SmartReaderJobConfiguration.class, PrimaryDataSourceConfiguration.class, DumpDataSourceConfiguration.class}, initializers = ConfigDataApplicationContextInitializer.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class SmartApplicationIntegrationTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;
    @Autowired
    private IntegrationTestRepository integrationTestRepository;

    private JobExecution jobExecution;

    @Value("${dump-data-file-name}")
    private String dumpDataFileName;

    @Value("${fileName}")
    private String mockDataFileName;

    @Test
    public void test() throws Exception {
        runApplication();
        testSmartPersonTableCount();
        testSmartMockDataTableCount();
        testSmartListingStatusTable();
        testSmartMarketplaceTable();
        compareFiles("dump_data_test.csv", dumpDataFileName);
        compareFiles("mock_data_test.csv", mockDataFileName);
        compareFiles("ftp_dump_test.txt", getFtpDumpFilePath());
    }

    private String getFtpDumpFilePath() {
        return jobExecution
                .getExecutionContext()
                .getString("fileName");
    }

    private void compareFiles(String expected, String actual) throws Exception {
        assertFileEquals(new ClassPathResource(expected), new PathResource(actual));
    }

    private void testSmartMarketplaceTable() {
        List<Marketplace> marketplaces = integrationTestRepository.getMarketplaces();
        List<Marketplace> marketplaceStubs = MarketplaceStub.getMarketplaceStubs();
        log.info(Arrays.toString(marketplaces.toArray()));
        log.info(Arrays.toString(marketplaceStubs.toArray()));
        assertTrue(CollectionUtils.isEqualCollection(marketplaces, marketplaceStubs));
    }

    private void testSmartListingStatusTable() {
        List<ListingStatus> listingStatuses = integrationTestRepository.getListingStatuses();
        List<ListingStatus> listingStatusStubs = ListingStatusStub.getListingStatusStubs();
        log.info(Arrays.toString(listingStatuses.toArray()));
        log.info(Arrays.toString(listingStatusStubs.toArray()));
        assertTrue(CollectionUtils.isEqualCollection(listingStatuses, listingStatusStubs));
    }

    private void testSmartMockDataTableCount() {
        assertEquals(30, integrationTestRepository.getSmartMockDataCount());
    }

    private void testSmartPersonTableCount() {
        assertEquals(30, integrationTestRepository.getSmartPersonCount());
    }

    private void runApplication() throws Exception {
        JobParameters jobParameters = jobLauncherTestUtils.getUniqueJobParameters();
        jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }

}
