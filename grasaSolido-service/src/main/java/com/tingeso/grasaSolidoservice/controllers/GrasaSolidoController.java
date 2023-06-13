package com.tingeso.grasaSolidoservice.controllers;

import com.tingeso.grasaSolidoservice.entities.GrasaSolidoEntity;
import com.tingeso.grasaSolidoservice.services.GrasaSolidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/grasas")
public class GrasaSolidoController {

    @Autowired
    GrasaSolidoService grasaSolidoService;

    @GetMapping
    public ResponseEntity<ArrayList<GrasaSolidoEntity>> obtenerData() {
        ArrayList<GrasaSolidoEntity> data = grasaSolidoService.obtenerGS();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void guardarData(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws FileNotFoundException, ParseException {
        grasaSolidoService.eliminarGS();
        grasaSolidoService.guardarGS(file);
        String filename = file.getOriginalFilename();
        redirectAttributes.addFlashAttribute("mensaje", "Archivo cargado con éxito");
        grasaSolidoService.leerCsv(filename);
    }
}
