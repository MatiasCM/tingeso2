package com.tingeso.acopioLecheservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acopios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcopioLecheEntity {
    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_acopio;
    private String fecha;
    private Integer kls_leche;
    private String proveedor;
    private String turno;
}
