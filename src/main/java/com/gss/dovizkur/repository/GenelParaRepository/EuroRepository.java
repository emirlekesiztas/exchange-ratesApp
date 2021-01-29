package com.gss.dovizkur.repository.GenelParaRepository;

import com.gss.dovizkur.domain.GenelParaDomain.EUR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EuroRepository extends JpaRepository<EUR,Long> {
    List<EUR> findAllByAlisNotNullOrderByAlisAsc();
    List<EUR> findAllBySatisNotNullOrderBySatisAsc();
}
