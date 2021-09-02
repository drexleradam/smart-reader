package hu.big.brain.csv.apilistingstatus.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListingStatus {
    private Long id;
    @JsonAlias("status_name")
    private String statusName;
}
