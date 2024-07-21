package guru.qa.country.controller;

import guru.qa.country.model.Country;
import guru.qa.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    List<Country> allCountries() {
        return countryService.allCountries();
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/renameCountry")
    public Country renameCountry(@RequestParam UUID id, @RequestParam String name) {
        return countryService.renameCountry(id, name);
    }

    @PatchMapping("/updateCountry")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }
}
