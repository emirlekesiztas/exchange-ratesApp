package com.gss.dovizkur.model.GenelParaModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
public class EUR {

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
