package com.gss.dovizkur.repository.GenelParaRepository;

import com.gss.dovizkur.domain.GenelParaDomain.USD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DolarRepository extends JpaRepository<USD,Long> {
    List<USD> findAllByAlisNotNullOrderByAlisAsc();
    List<USD> findAllBySatisNotNullOrderBySatis();
}
