package com.investment.alphavantageapi.api.company;

import com.investment.alphavantageapi.model.company.CompanyOverviewData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlphaVantageCompanyOverviewApi implements CompanyOverviewApi {

    private RestTemplate restTemplate;

    @Autowired
    public AlphaVantageCompanyOverviewApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CompanyOverviewData getCompanyOverviewData(String ticker) {

        ResponseEntity result = restTemplate.getForEntity("http://alphavantage:5151/companyOverview?ticker=" + ticker,
                CompanyOverviewData.class);

        CompanyOverviewData companyOverviewData = (CompanyOverviewData) result.getBody();

        return CompanyOverviewData.builder()
                .symbol(companyOverviewData.getSymbol())
                .name(companyOverviewData.getName())
                .description(companyOverviewData.getDescription())
                .exchange(companyOverviewData.getExchange())
                .peRatio(companyOverviewData.getPeRatio())
                .sector(companyOverviewData.getSector())
                .build();
    }

}
