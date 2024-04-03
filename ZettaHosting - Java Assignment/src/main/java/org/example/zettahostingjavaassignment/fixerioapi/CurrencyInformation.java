package org.example.zettahostingjavaassignment.fixerioapi;

import org.example.zettahostingjavaassignment.models.Currencies;
import org.example.zettahostingjavaassignment.models.dto.CurrencyDTO;
import org.example.zettahostingjavaassignment.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyInformation {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyInformation(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    //Runs every 5 hour(specified in milliseconds)
    @Scheduled(fixedRate = 5 * 1000 & 60 * 60)
    private void getRates() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject(
                    "http://data.fixer.io/api/latest?access_key=8e32656c74f781d0f3a8dfd9cbd24ea7",
                    CurrencyDTO.class);
            assert forObject != null;
            forObject.getRates().forEach((key, value) -> {
                Currencies currency = new Currencies(key, value);
                this.currencyRepository.save(currency);
            });
        } catch (RestClientException e){
            System.out.println(e.getMessage());
        }
    }
}
