package com.gss.dovizkur.service;

import com.gss.dovizkur.client.GenelParaClient.GenelParaClient;
import com.gss.dovizkur.domain.GenelParaDomain.EUR;
import com.gss.dovizkur.domain.GenelParaDomain.Root2;
import com.gss.dovizkur.domain.GenelParaDomain.USD;
import com.gss.dovizkur.repository.GenelParaRepository.DolarRepository;
import com.gss.dovizkur.repository.GenelParaRepository.EuroRepository;
import com.gss.dovizkur.repository.GenelParaRepository.Root2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Root2Service {

    private final Root2Repository root2Repository;
    private final GenelParaClient money2Client;
    private final EuroRepository euroRepository;
    private final DolarRepository dolarRepository;

    @Scheduled(fixedRate=60*60*1000)
    public void setMoney2(){
        if(root2Repository.count() >= 30){
            root2Repository.deleteAll();
        }
        root2Repository.save(money2Client.getExchange().getContent());
    }

    public List<Root2> getAllMoney2(){
        return root2Repository.findAll();
    }

    public List<EUR> getEurosByAlisAsc(){
        return euroRepository.findAllByAlisNotNullOrderByAlisAsc();
    }

    public List<EUR> getEurosBySatisAsc(){ return  euroRepository.findAllBySatisNotNullOrderBySatisAsc();}

    public List<USD> getUsdByAlisAsc(){return dolarRepository.findAllByAlisNotNullOrderByAlisAsc();}

    public List<USD> getUsdBySatisAsc(){return dolarRepository.findAllBySatisNotNullOrderBySatis();}


}
