package com.investment.alphavantageapi.api.sma;

import com.investment.alphavantageapi.api.sma.AlphaVantageSimpleMovingDayAverageApi;
import com.investment.alphavantageapi.model.sma.MetaData;
import com.investment.alphavantageapi.model.sma.SimpleMovingDayAverageData;
import com.investment.alphavantageapi.model.sma.SmaData;
import com.investment.alphavantageapi.model.sma.TechnicalAnalysis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AlphaVantageSimpleMovingDayAverageApiTest {

    @InjectMocks
    private AlphaVantageSimpleMovingDayAverageApi alphaVantageApi;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldRetrieveSimpleMovingDayAverageDataFromAlphaVantageApi() {
        String ticker = "IBM";
        String indicator = "Technical Analysis : SMA";

        SimpleMovingDayAverageData smaData = SimpleMovingDayAverageData.builder()
                .metaData(MetaData.builder()
                        .symbol(ticker)
                        .indicator(indicator)
                        .build())
                .technicalAnalysis(TechnicalAnalysis.builder()
                        .simpleMovingDayAverages(List.of(SmaData.builder().date("2021-04-09").simpleMovingDayAverage("123").build()))
                        .build())
                .build();

        when(restTemplate.getForEntity("http://alphavantage:5151/simpleMovingDayAverage?ticker=" + ticker, SimpleMovingDayAverageData.class))
                .thenReturn(ResponseEntity.ok(smaData));

        SimpleMovingDayAverageData result = alphaVantageApi.getSimpleMovingDayAverageFor(ticker);
        assertNotNull(result);
        assertEquals(ticker, result.getMetaData().getSymbol());
        assertEquals(indicator, result.getMetaData().getIndicator());
        assertNotNull(result.getTechnicalAnalysis());
        verify(restTemplate).getForEntity("http://alphavantage:5151/simpleMovingDayAverage?ticker=" + ticker, SimpleMovingDayAverageData.class);
    }
}
