package com.investment.alphavantageapi.model.sma;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class SmaData {

    private String date;
    private String simpleMovingDayAverage;

}
