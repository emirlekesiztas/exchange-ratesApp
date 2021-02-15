package com.gss.dovizkur.repository;

import com.gss.dovizkur.domain.RootDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RootRepository extends JpaRepository<RootDomain,Long> {
    List<RootDomain> findAllByDateEquals(LocalDate localDate);
    List<RootDomain> findAllByBaseApiEquals(String baseApi);
    List<RootDomain> findAllByBasePrEquals(String basePr);
    List<RootDomain> findAllByTargetPrEquals(String targetPr);
    List<RootDomain> findAllBySatisNotNullOrderBySatisDesc();
    List<RootDomain> findAllByAlisNotNullOrderByAlisDesc();
}
