package hu.big.brain.csv;

import hu.big.brain.model.ListingStatus;
import hu.big.brain.model.Marketplace;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class IntegrationTestRepository {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<Marketplace> getMarketplaces() {
		return jdbcTemplate.query("select id, marketplace_name as name from smart_marketplace", new BeanPropertyRowMapper<>(Marketplace.class));
	}
	
	public List<ListingStatus> getListingStatuses() {
		return jdbcTemplate.query("select id, status_name as name from smart_listing_status", new BeanPropertyRowMapper<>(ListingStatus.class));
	}
	
	public int getSmartMockDataCount() {
		return jdbcTemplate.queryForObject(
				"select count(*) from smart_mock_data",
				EmptySqlParameterSource.INSTANCE,
				Integer.class);
	}
	
	public int getSmartPersonCount() {
		return jdbcTemplate.queryForObject(
				"select count(*) from smart_person",
				EmptySqlParameterSource.INSTANCE,
				Integer.class);
	}
}
