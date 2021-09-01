package hu.big.brain.csv.apilistingstatus.repository;

import hu.big.brain.csv.apilistingstatus.model.ListingStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ListingStatusRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(ListingStatus listingStatus) {
        jdbcTemplate.update("insert into smart_listing_status (id, status_name) values (:id, :statusName)", getParameterMap(listingStatus));
    }

    private MapSqlParameterSource getParameterMap(ListingStatus listingStatus) {
        return new MapSqlParameterSource().addValue("id", listingStatus.getId()).addValue("statusName",listingStatus.getStatusName());
    }

}
