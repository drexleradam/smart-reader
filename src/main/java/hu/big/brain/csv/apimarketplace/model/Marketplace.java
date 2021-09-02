package hu.big.brain.csv.apimarketplace.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Marketplace {
    private int id;
    @JsonAlias("marketplace_name")
    private String name;
}
