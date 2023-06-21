import React, { useState } from "react";
import styled from "styled-components";
import NavbarComponent3 from "./NavbarComponent3";
import ProveedorService from "../services/ProveedorService";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';
import { createGlobalStyle } from 'styled-components'


export default function NuevoProveedorComponent(props) {

    const initialState = {
        codigo: "",
        afecto_retencion: "",
        categoria: "",
        nombre_proveedor: ""
    };

    const [input, setInput] = useState(initialState);

    const changeCodigoHandler = event => {
        setInput({ ...input, codigo: event.target.value });
        console.log(input.codigo);
    };
    const changeRetencionHandler = event => {
        setInput({ ...input, afecto_retencion: event.target.value });
        console.log(input.afecto_retencion);
    };
    const changeCategoriaHandler = event => {
        setInput({ ...input, categoria: event.target.value });
        console.log(input.categoria);
    };
    const changeNombreHandler = event => {
        setInput({ ...input, nombre_proveedor: event.target.value });
        console.log(input.nombre_proveedor);
    };

    const ingresarProveedor = e => {
        e.preventDefault();
        swal({
            title: "¿Está seguro de que desea ingresar al proveedor?",
            text: "Una vez ingresado, no podrá ser modificado.",
            icon: "warning",
            buttons: ["Cancelar", "Enviar"],
            dangerMode: true
        }).then(respuesta=>{
            if(respuesta){
                swal("Proveedor ingresado correctamente!", {icon: "success", timer: "3000"});
                let proveedor = { codigo: input.codigo, afecto_retencion: input.afecto_retencion, categoria: input.categoria, nombre_proveedor: input.nombre_proveedor};
                console.log(input.codigo)
                console.log(input.afecto_retencion)
                console.log(input.categoria)
                console.log(input.nombre_proveedor)
                console.log("proveedor => " + JSON.stringify(proveedor));
                ProveedorService.IngresarProveedor(proveedor).then(
                    (res) => {
                    }
                  );
                }
            else{
                swal({text: "Proveedor no ingresado.", icon: "error"});
            }
        });
    };



    return (
        <div>
            <GlobalStyle />
            <NavbarComponent3 />
            <Styles>
                <div className="mainclass">
                    <div>
                        <h1>Registrar nuevo Proveedor</h1>
                    <div className="formcontainer" align="center">
                        <hr />
                        <div className=" container">
                            <Form>
                                <Form.Group controlId="codigo" value={input.codigo} onChange={changeCodigoHandler}>
                                    <Form.Label>
                                        <strong>Codigo</strong>
                                    </Form.Label>
                                    <Form.Control
                                        type="codigo"
                                        placeholder="Ingrese el código del proveedor"
                                    />
                                </Form.Group>
                                <Form.Group controlId="afecto_retencion">
                                    <Form.Label>
                                        <strong>Retención</strong>
                                    </Form.Label>
                                    <Form.Control as="select" name="afecto_retencion" value={input.afecto_retencion} onChange={changeRetencionHandler}>
                                        <option value="Si">Si</option>
                                        <option value="No">No</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group controlId="categoria" value={input.categoria} onChange={changeCategoriaHandler}>
                                    <Form.Label>
                                        <strong>Categoría</strong>
                                    </Form.Label>
                                    <Form.Control as="select" name="categoria">
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                        <option value="C">C</option>
                                        <option value="D">D</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group controlId="nombre_proveedor" value={input.nombre_proveedor} onChange={changeNombreHandler}>
                                <Form.Label>
                                    <strong>Nombre</strong>
                                </Form.Label>
                                <Form.Control
                                    type="nombre_proveedor"
                                    placeholder="Ingrese el nombre del proveedor"
                                />
                                    </Form.Group>
                            </Form>
                        </div>
                        <Button className="btn-3" onClick={ingresarProveedor}>Registrar Proveedor</Button>
                    </div>
                    </div>
                </div>
            </Styles>
        </div>
    )
}

const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`
const Styles = styled.div`
.mainclass{
margin - top: 20px;
display: flex;
justify-content: center;
font-family: Roboto, Arial, sans-serif;
font-size: 15px;
}
.btn-3 button{
    margin-left: 0px;
    font-weight: 700;
    background-color: #4591e7;
    color: black;
    padding: 10px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}
.btn-3 button:hover {
    opacity: 0.8;
}
`