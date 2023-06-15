package com.tingeso.pagoservice.controllers;

import com.tingeso.pagoservice.entities.PagoEntity;
import com.tingeso.pagoservice.models.AcopioLecheModel;
import com.tingeso.pagoservice.models.GrasaSolidoModel;
import com.tingeso.pagoservice.models.ProveedorModel;
import com.tingeso.pagoservice.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    PagoService pagoService;

    /*@Autowired
    private ProveedorService proveedorService;

    @Autowired
    private AcopioLecheService acopioLecheService;

    @Autowired
    private GrasaSolidoService grasaSolidoService;*/

    @GetMapping("/listarPagos")
    public ResponseEntity<List<PagoEntity>> obtenerPagos(){
        List<PagoEntity> pagos = pagoService.obtenerPagos();
        //if(pagos.isEmpty())
            //return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pagos);
    }

    @GetMapping("/calcular")
    public ResponseEntity<List<PagoEntity>> calcular(){
        //pagoService.eliminarPagos();
        List<ProveedorModel> proveedores = pagoService.obtenerProveedores();
        for(ProveedorModel proveedor:proveedores){
            String codigo = proveedor.getCodigo();
            String categoria = proveedor.getCategoria();
            PagoEntity pago = new PagoEntity(null, "", codigo, proveedor.getNombre_proveedor(), 0, 0, 0.0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            List<AcopioLecheModel> acopios = pagoService.obtenerAcopioPorProveedor(codigo);
            double kls_leche = pagoService.sumarKls(codigo);
            double klsPorCategoria = pagoService.klsPorCategoria(categoria, kls_leche);
            GrasaSolidoModel gs = pagoService.obtenerGSPorProveedor(codigo);
            double pagoGrasa;
            double grasa = 0.0;
            double st;
            double pagoST;
            if(gs == null){
                //GrasaSolidoEntity newGS = new GrasaSolidoEntity(null,codigo,0,0);
                pagoGrasa = pagoService.pagoPorGrasa(0.0, kls_leche);
                st = 0.0;
                pagoST = 0.0;

            }else{
                grasa = pagoService.obtenerGrasa(codigo);
                pagoGrasa = pagoService.pagoPorGrasa(grasa, kls_leche);
                st = pagoService.obtenerST(codigo);
                pagoST = pagoService.pagoPorST(st, kls_leche);
            }
            //double pagoGrasa = grasaSolidoService.pagoPorGrasa(grasa, kls_leche);
            double bono = pagoService.bonoFrecuencia(codigo, kls_leche);
            double pagoAcopioLeche = klsPorCategoria + pagoGrasa + pagoST + bono;

            String quincena = pagoService.obtenerQuincena(codigo);
            ArrayList<PagoEntity> pagosProveedor = pagoService.obtenerPagosByCodigoProveedor(codigo);
            PagoEntity ultimoPago = pagoService.obtenerUltimoPago(codigo);
            double totalKlsUltimoPago = pagoService.obtenerTotalKls(ultimoPago);
            int variacionLeche = pagoService.variacionLeche(totalKlsUltimoPago, kls_leche);
            double descuentoLeche = kls_leche * (variacionLeche / 100.0);
            double grasaUltimoPago = pagoService.obtenerGrasa(ultimoPago);
            int variacionGrasa = pagoService.variacionGrasa(grasaUltimoPago, grasa);
            double descuentoGrasa = grasa * (variacionGrasa / 100.0);
            double stUltimoPago = pagoService.obtenerSt(ultimoPago);
            int variacionSt = pagoService.variacionSt(stUltimoPago, st);
            double descuentoSt = st * (variacionSt / 100.0);
            double descuentos = descuentoLeche + descuentoGrasa + descuentoSt;
            double pagoTotal = pagoAcopioLeche - descuentos;

            double retencion = 0.0;
            if(pagoTotal >= 950000){
                retencion = pagoTotal * 0.13;
            }
            double pagoFinal = pagoTotal - retencion;

            pago.setQuincena(quincena);
            pago.setTotal_kls(kls_leche);
            pago.setDias(pagoService.cantidadDias(codigo));
            //pago.setPromedio_kls(pagoService.promedioKls(codigo));
            pago.setVariacion_leche(variacionLeche);
            pago.setGrasa(grasa);
            pago.setVariacion_grasa(variacionGrasa);
            pago.setSolidos_totales(st);
            pago.setVariacion_st(variacionSt);
            pago.setPago_leche(klsPorCategoria);
            pago.setPago_grasa(pagoGrasa);
            pago.setPago_st(pagoST);
            pago.setBono(bono);
            pago.setDcto_leche(descuentoLeche);
            pago.setDcto_grasa(descuentoGrasa);
            pago.setDcto_st(descuentoSt);
            pago.setTotal(pagoTotal);
            pago.setMonto_retencion(retencion);
            pago.setMonto_final(pagoFinal);
            pagoService.guardarPago(pago);
        }
        List<PagoEntity> pagos = pagoService.obtenerPagos();
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }
}
