package com.investment.alphavantageapi.model.sma;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimpleMovingDayAverageData {

    @SerializedName("Meta Data")
    private MetaData metaData;

    @SerializedName("Technical Analysis: SMA")
    private TechnicalAnalysis technicalAnalysis;

}
