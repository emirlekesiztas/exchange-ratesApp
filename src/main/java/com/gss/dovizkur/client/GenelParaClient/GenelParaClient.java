package com.gss.dovizkur.client.GenelParaClient;

import com.gss.dovizkur.model.GenelParaModel.Root2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://api.genelpara.com/embed/doviz.json",name = "MONEY2-CLIENTS")
public interface GenelParaClient {
    @GetMapping
    EntityModel<Root2> getExchange();
}
