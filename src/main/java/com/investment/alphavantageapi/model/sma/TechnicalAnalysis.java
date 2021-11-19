package com.investment.alphavantageapi.model.sma;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TechnicalAnalysis {

    public List<SmaData> simpleMovingDayAverages;

}