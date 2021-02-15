package com.gss.dovizkur.client.CurrencyLayerClient;

import com.gss.dovizkur.model.CurrencyLayerModel.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://api.exchangeratesapi.io/latest?base=TRY",name = "MONEY3-CLIENTS")
public interface CurrencyLayerClient {
    @GetMapping
    EntityModel<Root> getExchange();
}
