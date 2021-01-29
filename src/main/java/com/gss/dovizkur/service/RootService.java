package com.gss.dovizkur.service;

import com.gss.dovizkur.client.CurrencyLayerClient.CurrencyLayerClient;
import com.gss.dovizkur.domain.CurrencyLayerDomain.Root;
import com.gss.dovizkur.repository.CurrencyLayerDomain.RootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RootService{

    private final CurrencyLayerClient moneyClient;
    private final RootRepository rootRepository;

    @Scheduled(fixedRate=60*60*1000)
    public void setEx() {
        if (rootRepository.count() >= 30){
            rootRepository.deleteAll();
        }
        rootRepository.save(moneyClient.getExchange().getContent());
    }

    public List<Root> getEx(){
        return rootRepository.findAll();
    }


    public List<Root> getExchangesByDate(LocalDate date){
        //TODO
        return rootRepository.findAllByDateEquals(date);
    }





}
