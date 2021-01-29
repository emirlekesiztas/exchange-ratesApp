package com.gss.dovizkur.domain.GenelParaDomain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "eur")
@Data
public class EUR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("satis")
    @Column(name = "satis")
    private String satis;
    @JsonProperty("alis")
    @Column(name = "alis")
    private String alis;
    @Column(name = "degisim")
    @JsonProperty("degisim")
    private String degisim;
}
