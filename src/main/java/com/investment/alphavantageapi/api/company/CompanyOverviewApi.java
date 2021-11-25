package com.investment.alphavantageapi.api.company;

import com.investment.alphavantageapi.model.company.CompanyOverviewData;

public interface CompanyOverviewApi {

    CompanyOverviewData getCompanyOverviewData(String ticker);

}
