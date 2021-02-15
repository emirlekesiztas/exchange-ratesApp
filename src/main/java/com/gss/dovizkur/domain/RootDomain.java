package com.gss.dovizkur.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "root")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RootDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "baseApi")
    private String baseApi;
    @Column(name = "basePr")
    private String basePr;
    @Column(name = "targetPr")
    private String targetPr;
    @Column(name = "alis")
    private Double alis;
    @Column(name = "satis")
    private Double satis;
    @Column(name = "date")
    private LocalDate date;
}
