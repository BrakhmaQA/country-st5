package guru.qa.country.service;

import guru.qa.country.data.CountryEntity;
import guru.qa.country.data.CountryRepository;
import guru.qa.country.model.Country;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> allCountries() {
        return countryRepository.findAll()
                .stream()
                .map(e -> new Country(
                        e.getId(),
                        e.getName(),
                        e.getCode(),
                        e.getDateOfIndependence()
                ))
                .toList();
    }

    public Country addCountry(@Nonnull Country Country) {
        CountryEntity countryEntity = CountryEntity.fromJson(Country);

        return Country.fromEntity(countryRepository.save(countryEntity));
    }

    @Transactional
    public Country renameCountry(UUID id, String newName) {
        CountryEntity countryEntity = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));
        countryEntity = new CountryEntity(countryEntity.getId(),
                newName,
                countryEntity.getCode(),
                countryEntity.getDateOfIndependence());
        countryRepository.save(countryEntity);

        return Country.fromEntity(countryEntity);
    }

    public Country updateCountry(Country country) {
        CountryEntity findCountry = countryRepository.findByCountryCode(country.code());
        findCountry.setName(country.name());

        return Country.fromEntity(countryRepository.save(findCountry));
    }
}
