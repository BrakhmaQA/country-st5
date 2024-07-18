package guru.qa.country.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class CountryConfig {
    @Bean
    public ObjectMapper objectMapper() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);

        return mapper;
    }
}
