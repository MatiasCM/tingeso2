package com.tingeso.grasaSolidoservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grasas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GrasaSolidoEntity {
    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_gs;
    private String proveedor;
    private Integer grasa;
    private Integer solido;

}
