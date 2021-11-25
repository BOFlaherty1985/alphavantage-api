package com.investment.alphavantageapi.api.company;

import com.investment.alphavantageapi.model.company.CompanyOverviewData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AlphaVantageCompanyOverviewApiTest {

    private static final String TICKER = "IBM";

    @InjectMocks
    private AlphaVantageCompanyOverviewApi alphaVantageCompanyOverviewApi;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldNotReturnNullWhenCallingCompanyOverviewApi() {
        // given

        // when
        CompanyOverviewData result = alphaVantageCompanyOverviewApi.getCompanyOverviewData(TICKER);

        // then
        assertNotNull(result);
    }

    @Test
    public void shouldCallAlphaVantageApiServiceViaRestTemplate() {
        // given

        // when
        alphaVantageCompanyOverviewApi.getCompanyOverviewData(TICKER);

        // then
        verify(restTemplate)
                .getForEntity("http://localhost:5555/companyOverview?ticker=" + TICKER, CompanyOverviewData.class);
    }

    @Test
    public void shouldBuildCompanyOverviewDataObject() {
        // given
        CompanyOverviewData companyOverviewData
                = CompanyOverviewData.builder()
                .symbol(TICKER)
                .name("IBM")
                .description("Company Description")
                .exchange("NYSE")
                .peRatio("10")
                .sector("Technology")
                .build();

        given(restTemplate.getForEntity("http://localhost:5555/companyOverview?ticker=" + TICKER, CompanyOverviewData.class))
                .willReturn(ResponseEntity.ok(companyOverviewData));


        // when
        CompanyOverviewData result = alphaVantageCompanyOverviewApi.getCompanyOverviewData(TICKER);

        // then
        assertEquals(companyOverviewData.getSymbol(), result.getSymbol());
        assertEquals(companyOverviewData.getName(), result.getName());
        assertEquals(companyOverviewData.getDescription(), result.getDescription());
        assertEquals(companyOverviewData.getExchange(), result.getExchange());
        assertEquals(companyOverviewData.getPeRatio(), result.getPeRatio());
        assertEquals(companyOverviewData.getSector(), result.getSector());
    }
}
