package com.gss.dovizkur.model.CurrencyLayerModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;


@Data
public class Rates {
    @JsonProperty("USD")
    @Column(name = "USD")
    public double uSD;
    @JsonProperty("EUR")
    @Column(name = "EUR")
    public double eUR;
}
