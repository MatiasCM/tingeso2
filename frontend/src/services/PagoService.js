import axios from "axios";

const API_URL = "http://localhost:8080/pagos/calcular";

class PagoService {
    getPagos() {
        return axios.get(API_URL);
    }
}

export default new PagoService();