package com.tingeso.pagoservice.controllers;

import com.tingeso.pagoservice.entities.PagoEntity;
import com.tingeso.pagoservice.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    /*@Autowired
    private ProveedorService proveedorService;

    @Autowired
    private AcopioLecheService acopioLecheService;

    @Autowired
    private GrasaSolidoService grasaSolidoService;*/

    @GetMapping
    public ResponseEntity<List<PagoEntity>> obtenerPagos(){
        List<PagoEntity> pagos = pagoService.obtenerPagos();
        if(pagos.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pagos);
    }
}
