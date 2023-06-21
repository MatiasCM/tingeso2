package com.tingeso.proveedorservice.controllers;

import com.tingeso.proveedorservice.entities.ProveedorEntity;
import com.tingeso.proveedorservice.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/listaProveedores")
    public ResponseEntity<List<ProveedorEntity>> listar(){
        List<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        //if(proveedores.isEmpty())
            //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PostMapping
    public void guardarProveedor(@RequestBody ProveedorEntity proveedor){
        String codigo = proveedor.getCodigo();
        String afecto_retencion = proveedor.getAfecto_retencion();
        String categoria = proveedor.getCategoria();
        String nombre_proveedor = proveedor.getNombre_proveedor();
        proveedorService.guardarProveedor(codigo, afecto_retencion, categoria, nombre_proveedor);
    }

    @GetMapping("/{proveedor}")
    public ResponseEntity<ProveedorEntity> obtenerProveedor(@PathVariable String codigo){
        ProveedorEntity proveedor = proveedorService.obtenerProveedor(codigo);
        if(proveedor == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedor);
    }
}
