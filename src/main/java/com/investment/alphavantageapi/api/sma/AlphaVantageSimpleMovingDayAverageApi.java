package com.investment.alphavantageapi.api.sma;

import com.investment.alphavantageapi.model.sma.SimpleMovingDayAverageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlphaVantageSimpleMovingDayAverageApi implements SimpleMovingDayAverageApi {

    private RestTemplate restTemplate;

    @Autowired
    public AlphaVantageSimpleMovingDayAverageApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SimpleMovingDayAverageData getSimpleMovingDayAverageFor(String ticker) {

        ResponseEntity<SimpleMovingDayAverageData> result
                = restTemplate.getForEntity("http://alphavantage:5151/simpleMovingDayAverage?ticker=" + ticker, SimpleMovingDayAverageData.class);

        SimpleMovingDayAverageData response = result.getBody();
        return SimpleMovingDayAverageData.builder()
                .metaData(response.getMetaData())
                .technicalAnalysis(response.getTechnicalAnalysis())
                .build();
    }
}
