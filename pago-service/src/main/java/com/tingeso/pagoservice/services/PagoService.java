package com.tingeso.pagoservice.services;

import com.tingeso.pagoservice.entities.PagoEntity;
import com.tingeso.pagoservice.models.AcopioLecheModel;
import com.tingeso.pagoservice.models.GrasaSolidoModel;
import com.tingeso.pagoservice.models.ProveedorModel;
import com.tingeso.pagoservice.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    RestTemplate restTemplate;

    //obtener pagos
    public ArrayList<PagoEntity> obtenerPagos(){
        return (ArrayList<PagoEntity>) pagoRepository.findAll();
    }

    //guardar pago
    public void guardarPago(PagoEntity pago){
        pagoRepository.save(pago);
    }

    public void eliminarPagos(){pagoRepository.deleteAll();}

    //obtener pago por codigo_proveedor
    public ArrayList<PagoEntity> obtenerPagosByCodigoProveedor(String codigo_proveedor){
        return pagoRepository.findPagosByCodigoProveedor(codigo_proveedor);
    }

    //de la lista de pagos por codigo obtener el ultimo
    public PagoEntity obtenerUltimoPago(String codigo_proveedor){
        return pagoRepository.findUltimoPagoByCodigoProveedor(codigo_proveedor);
    }

    //obtener kls_leche de un pago
    public double obtenerTotalKls(PagoEntity pago){
        if(pago == null)
            return 0.0;
        else
            return pago.getTotal_kls();
    }

    //calcular variacion negativa de leche
    public int variacionLeche(double klsAnterior, double klsActual){
        int descuento = 0;
        double variacion = ((klsAnterior - klsActual)/klsAnterior)*100;
        if(variacion >= 0 && variacion <= 8){
            descuento = 0;
        }else if(variacion >= 9 && variacion <= 25){
            descuento = 7;
        }else if(variacion >= 26 && variacion <= 45){
            descuento = 15;
        }else if(variacion >= 46){
            descuento = 30;
        }
        return descuento;
    }

    //obtener grasa de un pago
    public double obtenerGrasa(PagoEntity pago){
        if(pago == null)
            return 0.0;
        else
            return pago.getGrasa();
    }

    //calcular variacion negativa de grasa
    public int variacionGrasa(double grasaAnterior, double grasaActual){
        int descuento = 0;
        double variacion = ((grasaAnterior - grasaActual)/grasaAnterior)*100;
        if(variacion >= 0 && variacion <= 15){
            descuento = 0;
        }else if(variacion >= 16 && variacion <= 25){
            descuento = 12;
        }else if(variacion >= 26 && variacion <= 40){
            descuento = 20;
        }else if(variacion >= 41){
            descuento = 30;
        }
        return descuento;
    }

    //obtener st de un pago
    public double obtenerSt(PagoEntity pago){
        if(pago == null)
            return 0.0;
        else
            return pago.getSolidos_totales();
    }

    //calcular variacion negativa de st
    public int variacionSt(double stAnterior, double stActual){
        int descuento = 0;
        double variacion = ((stAnterior - stActual)/stAnterior)*100;
        if(variacion >= 0 && variacion <= 6){
            descuento = 0;
        }else if(variacion >= 7 && variacion <= 12){
            descuento = 18;
        }else if(variacion >= 13 && variacion <= 35){
            descuento = 27;
        }else if(variacion >= 36){
            descuento = 45;
        }
        return descuento;
    }

    public List<ProveedorModel> obtenerProveedores(){
        //List<ProveedorModel> proveedores = restTemplate.getForObject("http://proveedor-service/proveedores/listaProveedores", List.class);
        ResponseEntity<List<ProveedorModel>> response = restTemplate.exchange(
                "http://proveedor-service/proveedores/listaProveedores",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProveedorModel>>() {}
        );
        List<ProveedorModel> proveedores = response.getBody();
        return proveedores;
    }

    public List<AcopioLecheModel> obtenerAcopioPorProveedor(String codigo){
        List<AcopioLecheModel> acopios = restTemplate.getForObject("http://acopioLeche-service/acopios/" + codigo, List.class);
        return acopios;
    }

    public Double sumarKls(String codigo){
        Double kls = restTemplate.getForObject("http://acopioLeche-service/acopios/sumarKls/" + codigo, Double.class);
        return kls;
    }

    public Double klsPorCategoria(String categoria, double kls){
        //ProveedorModel proveedor = restTemplate.getForObject("http://proveedor-service/proveedores/" + codigo, ProveedorModel.class);
        //String categoria = proveedor.getCategoria();
        Double kilos = restTemplate.getForObject("http://acopioLeche-service/acopios/klsPorCategoria/" + categoria + "/" + kls, Double.class);
        return kilos;
    }

    public GrasaSolidoModel obtenerGSPorProveedor(String proveedor){
        GrasaSolidoModel grasa = restTemplate.getForObject("http://grasaSolido-service/grasas/" + proveedor, GrasaSolidoModel.class);
        return grasa;
    }

    public Double pagoPorGrasa(double grasa, double kilos){
        Double pago = restTemplate.getForObject("http://grasaSolido-service/grasas/pagoPorGrasa/" + grasa + "/" + kilos, Double.class);
        return pago;
    }

    public Double obtenerGrasa(String proveedor){
        Double grasa = restTemplate.getForObject("http://grasaSolido-service/grasas/obtenerGrasa/" + proveedor, Double.class);
        return grasa;
    }

    public Double obtenerST(String proveedor){
        Double st = restTemplate.getForObject("http://grasaSolido-service/grasas/obtenerST/" + proveedor, Double.class);
        return st;
    }

    public Double pagoPorST(double st, double kilos){
        Double pago = restTemplate.getForObject("http://grasaSolido-service/grasas/pagoPorGrasa/" + st + "/" + kilos, Double.class);
        return pago;
    }

    public Double bonoFrecuencia(String proveedor, double kls){
        Double bono = restTemplate.getForObject("http://acopioLeche-service/acopios/bonoFrecuencia/" + proveedor + "/" + kls, Double.class);
        return bono;
    }

    public String obtenerQuincena(String proveedor){
        String quincena = restTemplate.getForObject("http://acopioLeche-service/acopios/obtenerQuincena/" + proveedor, String.class);
        return quincena;
    }

    public Double cantidadDias(String proveedor){
        Double dias = restTemplate.getForObject("http://acopioLeche-service/acopios/cantidadDias/" + proveedor, Double.class);
        return dias;
    }

    public Double promedioKls(String proveedor){
        Double kls = restTemplate.getForObject("http://acopioLeche-service/acopios/promedioKls/" + proveedor, Double.class);
        return kls;
    }

}
