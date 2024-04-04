package org.example.zettahostingjavaassignment.fixerioapi;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.dto.CurrencyDTO;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyInformation {

    private final CurrencyRepository currencyRepository;

    @Value("${fixer.io.api-key}")
    private String fixerIoAPIKey;

    @Autowired
    public CurrencyInformation(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    //Runs every 5 hours(specified in milliseconds)
    @Scheduled(fixedRate = 5 * 1000 * 60 * 60)
    private void getRates() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject(
                    fixerIoAPIKey,
                    CurrencyDTO.class);
            forObject.getRates().forEach((key, value) -> {
                Currencies currency = new Currencies(key, value);
                this.currencyRepository.save(currency);
            });
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
