package com.investment.alphavantageapi.model.company;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyOverviewData {

    @SerializedName("Symbol")
    private String symbol;

    @SerializedName("Name")
    private String name;

    @SerializedName("Description")
    private String description;
    
    @SerializedName("Sector")
    private String sector;

    @SerializedName("PERatio")
    private String peRatio;

    @SerializedName("Exchange")
    private String exchange;

}
