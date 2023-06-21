import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import ProveedoresComponent from './components/ProveedoresComponent';
import NuevoProveedorComponent from './components/NuevoProveedorComponent';
import AcopioUploadComponent from './components/AcopioUploadComponent';
import AcopioInformationComponent from './components/AcopioInfomationComponent';
import GrasaInformationComponent from './components/GrasaInformationComponent';
import GrasaUploadComponent from './components/GrasaUploadComponent';
import PagoComponent from './components/PagoComponent';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path="/listar" element={<ProveedoresComponent />} />
        <Route path="/nuevo_proveedor" element={<NuevoProveedorComponent />} />
        <Route path="/fileUpload" element={<AcopioUploadComponent />} />
        <Route path="/fileInformation" element={<AcopioInformationComponent />} />
        <Route path="/fileUpload_grasa" element={<GrasaUploadComponent />} />
        <Route path="/fileInformation_grasa" element={<GrasaInformationComponent />} />
        <Route path="/calcular" element={<PagoComponent />} />

      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
