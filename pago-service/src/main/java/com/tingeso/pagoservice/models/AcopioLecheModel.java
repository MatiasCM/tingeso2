package com.tingeso.pagoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcopioLecheModel {
    private Integer id_acopio;
    private String fecha;
    private Integer kls_leche;
    private String proveedor;
    private String turno;
}
