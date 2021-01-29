package com.gss.dovizkur.domain.CurrencyLayerDomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ratess")
@Data
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("USD")
    @Column(name = "USD")
    public double uSD;
    @JsonProperty("EUR")
    @Column(name = "EUR")
    public double eUR;
}
