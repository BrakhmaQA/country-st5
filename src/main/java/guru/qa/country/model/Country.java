package guru.qa.country.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import guru.qa.country.data.CountryEntity;


import java.sql.Date;
import java.util.UUID;

public record Country(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("name")
        String name,
        @JsonProperty("code")
        String code,
        @JsonProperty("date_of_independence")
        Date dateOfIndependence) {

    public static Country fromEntity(CountryEntity countryEntity) {
        return new Country(
                countryEntity.getId(),
                countryEntity.getName(),
                countryEntity.getCode(),
                countryEntity.getDateOfIndependence()
        );
    }
}
