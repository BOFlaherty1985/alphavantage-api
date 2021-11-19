package com.investment.alphavantageapi.model.sma;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetaData {

    @SerializedName("1: Symbol")
    private String symbol;

    @SerializedName("2: Indicator")
    private String indicator;
}
