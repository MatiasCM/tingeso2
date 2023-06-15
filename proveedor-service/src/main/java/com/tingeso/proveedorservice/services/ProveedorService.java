package com.tingeso.proveedorservice.services;

import com.tingeso.proveedorservice.entities.ProveedorEntity;
import com.tingeso.proveedorservice.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public void guardarProveedor(String codigo, String afecto_retencion, String categoria, String nombre_proveedor){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setCodigo(codigo);
        proveedor.setAfecto_retencion(afecto_retencion);
        proveedor.setCategoria(categoria);
        proveedor.setNombre_proveedor(nombre_proveedor);
        proveedorRepository.save(proveedor);
    }

    public List<ProveedorEntity> obtenerProveedores(){
        return (List<ProveedorEntity>) proveedorRepository.findAll();
    }

    public ProveedorEntity obtenerProveedor(String codigo){
        return (ProveedorEntity) proveedorRepository.findByCodigo(codigo);
    }

}
