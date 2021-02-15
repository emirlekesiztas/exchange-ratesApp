package com.gss.dovizkur.api;

import com.gss.dovizkur.domain.RootDomain;
import com.gss.dovizkur.model.CurrencyLayerModel.Root;
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

    @RequestMapping("/all")
    public List<RootDomain> getAll(){
        return rootService.getAll();
    }

    @RequestMapping("/api1")
    public List<RootDomain> getAllByBaseApi(){
        return rootService.getAllByBaseApi("CurrencyLayer");
    }
    @RequestMapping("/api2")
    public List<RootDomain> getAllByBaseApi2(){
        return rootService.getAllByBaseApi("GenelPara");
    }

    @RequestMapping("/basepr/tl")
    public List<RootDomain> getAllByBasePr(){
        return rootService.getAllByBasePR("TL");
    }

    @RequestMapping("/today")
    public List<RootDomain> getAllByDate(){
        return rootService.getAllByDate(LocalDate.now());
    }

    @RequestMapping("/alis")
    public List<RootDomain> getAllByAlisDesc(){
        return rootService.getAllByAlisDesc();
    }

    @RequestMapping("/satis")
    public List<RootDomain> getAllBySatisDesc(){
        return rootService.getAllBySatisDesc();
    }

}
