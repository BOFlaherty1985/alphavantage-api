package com.investment.alphavantageapi.api.sma;

import com.investment.alphavantageapi.model.sma.SimpleMovingDayAverageData;

public interface SimpleMovingDayAverageApi {

    SimpleMovingDayAverageData getSimpleMovingDayAverageFor(String ticker);

}
