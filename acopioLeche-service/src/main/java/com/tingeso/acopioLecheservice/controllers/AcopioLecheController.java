package com.tingeso.acopioLecheservice.controllers;

import com.tingeso.acopioLecheservice.entities.AcopioLecheEntity;
import com.tingeso.acopioLecheservice.services.AcopioLecheService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
