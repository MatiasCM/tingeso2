import axios from "axios";

const API_URL = "http://localhost:8080/grasas";

class GrasaService{
    
    obtenerGS(){
        return axios.get(API_URL);
    }

    guardarData(file){
        return axios.post(API_URL, file);
    }
}

export default new GrasaService()