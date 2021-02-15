package com.gss.dovizkur.service;

import com.gss.dovizkur.client.CurrencyLayerClient.CurrencyLayerClient;
import com.gss.dovizkur.client.GenelParaClient.GenelParaClient;
import com.gss.dovizkur.domain.RootDomain;
import com.gss.dovizkur.model.CurrencyLayerModel.Root;
import com.gss.dovizkur.model.GenelParaModel.Root2;
import com.gss.dovizkur.repository.RootRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RootService{
    private static final String BASE_API = "CurrencyLayer";
    private static final String BASE_API2 = "GenelPara";
    private final CurrencyLayerClient moneyClient;
    private final RootRepository rootRepository;
    private final GenelParaClient money2Client;

    @Scheduled(fixedRate=60*60*1000)
    public void set1() {
        Root root = moneyClient.getExchange().getContent();
        RootDomain rootDomain = RootDomain.builder()
                .baseApi(BASE_API)
                .basePr(root.getBase())
                .targetPr("EUR")
                .alis(root.getRates().getEUR())
                .satis(root.getRates().getEUR())
                .date(root.getDate())
                .build();
        RootDomain rootDomain2 = RootDomain.builder()
                .baseApi(BASE_API)
                .basePr(root.getBase())
                .targetPr("USD")
                .alis(root.getRates().getUSD())
                .satis(root.getRates().getUSD())
                .date(root.getDate())
                .build();
        rootRepository.save(rootDomain);
    }

    @Scheduled(fixedRate=60*60*1000)
    public void setMoney1(){
        Root2 root2EUR = money2Client.getExchange().getContent();
        RootDomain rootDomain = RootDomain.builder()
                .baseApi(BASE_API2)
                .basePr("TL")
                .targetPr("EUR")
                .alis(Double.parseDouble(root2EUR.getEUR().getAlis()))
                .satis(Double.parseDouble(root2EUR.getEUR().getSatis()))
                .date(LocalDate.now())
                .build();

        Root2 root2USD = money2Client.getExchange().getContent();
        RootDomain rootDomain2 = RootDomain.builder()
                .basePr("TL")
                .baseApi(BASE_API2)
                .targetPr("EUR")
                .alis(Double.parseDouble(root2USD.getUSD().getAlis()))
                .satis(Double.parseDouble(root2USD.getUSD().getSatis()))
                .date(LocalDate.now())
                .build();
        rootRepository.save(rootDomain);
        rootRepository.save(rootDomain2);

    }

    public List<RootDomain> getAll(){
        return rootRepository.findAll();
    }

    public List<RootDomain> getAllByBaseApi(String baseApi){
        return rootRepository.findAllByBaseApiEquals(baseApi);
    }

    public List<RootDomain> getAllByDate(LocalDate date){
        return rootRepository.findAllByDateEquals(date);
    }

    public List<RootDomain> getAllByBasePR(String basePr){
        return rootRepository.findAllByBasePrEquals(basePr);
    }

    public List<RootDomain> getAllByTargetPr(String targetPr){
        return rootRepository.findAllByTargetPrEquals(targetPr);
    }

    public List<RootDomain> getAllByAlisDesc(){
        return rootRepository.findAllByAlisNotNullOrderByAlisDesc();
    }
    public List<RootDomain> getAllBySatisDesc(){
        return rootRepository.findAllBySatisNotNullOrderBySatisDesc();
    }





}
