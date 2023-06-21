import React, { Component } from "react";
import styled from "styled-components";
import NavbarComponent2 from "./NavbarComponent2";
import { createGlobalStyle } from 'styled-components'


class ProveedoresComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            proveedores: [],
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/proveedores/listaProveedores")
            .then((res) => res.json())
            .then((data) => {
                this.setState({ proveedores: data });
            })
            .catch(console.log);
    }

    render() {
        return (
            <div>
                <GlobalStyle />
                <NavbarComponent2 />
                <Styles>
                    <div align="center" class="container my-2">
                        <h1><b> Listado de proveedores</b></h1>
                        <table border="3" class="table table-primary table-striped table-bordered border-secondary">
                            <thead class="table-dark">
                                <tr>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                    <th>Categoria</th>
                                    <th>Retencion</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.proveedores.map((proveedor) => (
                                    <tr>
                                        <td>{proveedor.codigo}</td>
                                        <td>{proveedor.nombre_proveedor}</td>
                                        <td>{proveedor.categoria}</td>
                                        <td>{proveedor.afecto_retencion}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </Styles>
            </div>
        )
    }
}

export default ProveedoresComponent;

const Styles = styled.div`

body {
    background-color: lightblue;
  }
  `
  const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`