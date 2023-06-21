import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import ProveedoresComponent from './components/ProveedoresComponent';
import NuevoProveedorComponent from './components/NuevoProveedorComponent';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path="/listar" element={<ProveedoresComponent />} />
        <Route path="/nuevo_proveedor" element={<NuevoProveedorComponent />} />


      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;
