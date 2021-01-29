package com.gss.dovizkur.repository.CurrencyLayerDomain;

import com.gss.dovizkur.domain.CurrencyLayerDomain.Rates;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends JpaRepository<Rates,Long> {
}
