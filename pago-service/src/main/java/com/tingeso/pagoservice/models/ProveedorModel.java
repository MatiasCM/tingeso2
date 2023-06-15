package com.tingeso.pagoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorModel {
    private String codigo;
    private String afecto_retencion;
    private String categoria;
    private String nombre_proveedor;
}
