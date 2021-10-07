package hu.big.brain.csv.apimarketplace.repository;

import hu.big.brain.model.Marketplace;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MarketplaceRepository {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;
	
	public void save(Marketplace marketplace) {
		jdbcTemplate.update("insert into smart_marketplace (id, marketplace_name) values (:id, :name) on conflict do nothing ", new BeanPropertySqlParameterSource(marketplace));
	}
	
}
