package hu.big.brain.csv.client;

import feign.Headers;
import hu.big.brain.model.ListingStatus;
import hu.big.brain.model.Marketplace;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${mockaroo.name}", url = "${mockaroo.url}")
@ConditionalOnProperty("mockaroo.url")
public interface MockarooClient {
	
	@Headers("Content-Type: application/json")
	@GetMapping(value = "/listingStatus")
	List<ListingStatus> getListingStatus(@RequestParam String key);
	
	@Headers("Content-Type: application/json")
	@GetMapping(value = "/marketplace")
	List<Marketplace> getMarketplace(@RequestParam String key);
	
}
