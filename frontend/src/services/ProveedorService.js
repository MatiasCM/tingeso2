import axios from "axios";

class ProveedorService {
    
    obtenerProveedores(){
        return axios.get(`http://localhost:8080/proveedores/listaProveedores`);
    }
    IngresarProveedor(codigo, afecto_retencion, categoria, nombre_proveedor){
        return axios.post(`http://localhost:8080/proveedores`, codigo, afecto_retencion, categoria, nombre_proveedor);
    }
}

export default new ProveedorService();