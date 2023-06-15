package com.tingeso.pagoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrasaSolidoModel {
    private Integer id_gs;
    private String proveedor;
    private Integer grasa;
    private Integer solido;
}
