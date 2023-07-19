package com.hipermaxi.dtos;

import com.hipermaxi.model.TipoDocumento;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteUpdateDTO {
    private Long idCliente;
    private TipoDocumento idTipoDoc;
    private String numDocumento;
    private String nombre;
    private String apePat;
    private String apeMat;
    private Date fecNacimiento;
    private String email;
}
