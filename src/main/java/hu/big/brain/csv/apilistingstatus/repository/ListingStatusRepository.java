package hu.big.brain.csv.apilistingstatus.repository;

import hu.big.brain.csv.apilistingstatus.model.ListingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ListingStatusRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(ListingStatus listingStatus) {
        jdbcTemplate.update("insert into smart_listing_status (id, status_name) values (:id, :name) on conflict do nothing ", new BeanPropertySqlParameterSource(listingStatus));
    }

}
