package com.gss.dovizkur.repository.CurrencyLayerDomain;

import com.gss.dovizkur.domain.CurrencyLayerDomain.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RootRepository extends JpaRepository<Root,Long> {
    List<Root> findAllByDateEquals(LocalDate date);

}
