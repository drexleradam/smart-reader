package hu.big.brain.csv.apilistingstatus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListingStatus {
    private long id;
    @JsonProperty("status_name")
    private String statusName;
}
