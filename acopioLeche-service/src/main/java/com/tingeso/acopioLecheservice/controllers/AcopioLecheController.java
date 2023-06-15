package com.tingeso.acopioLecheservice.controllers;

import com.tingeso.acopioLecheservice.entities.AcopioLecheEntity;
import com.tingeso.acopioLecheservice.services.AcopioLecheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/acopios")
public class AcopioLecheController {

    @Autowired
    AcopioLecheService acopioLecheService;

    @GetMapping
    public ResponseEntity<ArrayList<AcopioLecheEntity>> obtenerData() {
        ArrayList<AcopioLecheEntity> data = acopioLecheService.obtenerAcopio();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void guardarData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws FileNotFoundException, ParseException {
        acopioLecheService.eliminarAcopios();
        acopioLecheService.guardarAcopio(file);
        String filename = file.getOriginalFilename();
        redirectAttributes.addFlashAttribute("mensaje", "Archivo cargado con éxito");
        acopioLecheService.leerCsv(filename);
    }

    @GetMapping("/{proveedor}")
    public ResponseEntity<ArrayList<AcopioLecheEntity>> obtenerAcopiosPorProveedor(@PathVariable String proveedor) {
        ArrayList<AcopioLecheEntity> acopios = acopioLecheService.obtenerPorProveedor(proveedor);
        return new ResponseEntity<>(acopios, HttpStatus.OK);
    }

    @GetMapping("/sumarKls/{proveedor}")
    public ResponseEntity<Double> sumarKls(@PathVariable String proveedor){
        ArrayList<AcopioLecheEntity> acopios = acopioLecheService.obtenerPorProveedor(proveedor);
        Double kls = acopioLecheService.sumarKls(acopios);
        return new ResponseEntity<>(kls, HttpStatus.OK);
    }

    @GetMapping("/klsPorCategoria/{categoria}/{kls}")
    public ResponseEntity<Double> KlsPorCategoria(@PathVariable String categoria, @PathVariable double kls){
        //ArrayList<AcopioLecheEntity> acopios = acopioLecheService.obtenerPorProveedor(proveedor);
        Double kilos = acopioLecheService.klsPorCategoria(categoria, kls);
        return new ResponseEntity<>(kilos, HttpStatus.OK);
    }

    @GetMapping("/bonoFrecuencia/{proveedor}/{kls}")
    public ResponseEntity<Double> bonoFrecuencia(@PathVariable String proveedor, @PathVariable double kls){
        Double bono = acopioLecheService.bonoFrecuencia(proveedor, kls);
        return new ResponseEntity<>(bono, HttpStatus.OK);
    }

    @GetMapping("/obtenerQuincena/{proveedor}")
    public ResponseEntity<String> obtenerQuincena(@PathVariable String proveedor) {
        String quincena = acopioLecheService.obtenerQuincena(proveedor);
        return new ResponseEntity<>(quincena, HttpStatus.OK);
    }

    @GetMapping("/cantidadDias/{proveedor}")
    public ResponseEntity<Double> cantidadDias(@PathVariable String proveedor) {
        Double dias = acopioLecheService.cantidadDias(proveedor);
        return new ResponseEntity<>(dias, HttpStatus.OK);
    }

    @GetMapping("/promedioKls/{proveedor}")
    public Double promedioKls(@PathVariable String proveedor){
        ArrayList<AcopioLecheEntity> acopios = acopioLecheService.obtenerPorProveedor(proveedor);
        Double kls = acopioLecheService.promedioKls(proveedor, acopios);
        return kls;
    }

}
