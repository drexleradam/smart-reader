package hu.big.brain.csv.ftp.send.client;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmartFtpClient {
	
	@Bean
	public FTPClient ftpClient() {
		return new FTPClient();
	}
}
