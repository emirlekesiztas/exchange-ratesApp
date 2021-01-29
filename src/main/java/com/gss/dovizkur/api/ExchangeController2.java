package com.gss.dovizkur.api;

import com.gss.dovizkur.domain.GenelParaDomain.EUR;
import com.gss.dovizkur.domain.GenelParaDomain.Root2;
import com.gss.dovizkur.domain.GenelParaDomain.USD;
import com.gss.dovizkur.service.Root2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get2")
public class ExchangeController2 {
    @Autowired
    private Root2Service root2Service;

    @GetMapping
    public List<Root2> getAll(){
        return root2Service.getAllMoney2(); // Base'i TRY olan Euro ve Dolar kurlarının hepsini getirir.
    }

    @GetMapping("/usd/alis")
    private List<USD> getAllUsdByAlis(){
        return root2Service.getUsdByAlisAsc();  // Base'i TRY olan Dolar kurlarını alış değerlerine göre sırayıp getirir.
    }

    @GetMapping("/usd/satis")
    private List<USD> getAllUsdBySatis(){
        return root2Service.getUsdBySatisAsc(); // Base'i TRY olan Dolar kurlarını satış değerlerine göre sırayıp getirir.
    }

    @GetMapping("/euro/alis")
    private List<EUR> getAllEuroByAlis(){
        return root2Service.getEurosByAlisAsc(); // Base'i TRY olan Euro kurlarını alış değerlerine göre sırayıp getirir.
    }

    @GetMapping("/euro/satis")
    private List<EUR> getAllEuroBySatis(){
        return root2Service.getEurosBySatisAsc(); // Base'i TRY olan Euro kurlarını satış değerlerine göre sırayıp getirir.
    }

}
