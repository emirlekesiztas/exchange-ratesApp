package com.gss.dovizkur.api;

import com.gss.dovizkur.domain.CurrencyLayerDomain.Root;
import com.gss.dovizkur.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/get")
public class ExchangeController1 {
    @Autowired
    private RootService rootService;

    @GetMapping("/latest1")
    public List<Root> getTets(){
        return rootService.getEx(); }  // Base'i TRY olacak şekilde Euro ve Dolar kurlarının güncel halini getirir.



    @GetMapping   // Base'i TRY olacak şekilde Euro ve Dolar kurlarının request parametre olarak girilen tarihe göre sıralayıp getirir.
    public List<Root> getExByDate(@RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate time) {
        System.out.println(time.toString());
       return rootService.getExchangesByDate(time);
    }




}
