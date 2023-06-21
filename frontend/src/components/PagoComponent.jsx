import React, { Component } from "react";
import NavbarComponent8 from "./NavbarComponent8";
import styled from "styled-components";
import { createGlobalStyle } from 'styled-components'


class PagoComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            pagos: [],
        };
    }

    componentDidMount() {
        this.actualizarPagos();
    }

    actualizarPagos() {
        fetch("http://localhost:8080/pagos/listarPagos")
            .then((response) => response.json())
            .then((data) => this.setState({ pagos: data }))
            .catch((error) => {
                console.error("Error al obtener los pagos:", error);
            });
    }

    calcularPagos() {
        fetch("http://localhost:8080/pagos/calcular", { method: "POST" })
            .then((response) => {
                if (response.ok) {
                    // Calcular y obtener nuevos datos exitosamente
                    this.actualizarPagos();
                    console.log("Nuevos pagos calculados");
                } else {
                    console.error("Error al calcular nuevos pagos:", response.statusText);
                }
            })
            .catch((error) => {
                console.error("Error al calcular nuevos pagos:", error);
            });
    }

    render() {
        return (
            <div>
                <GlobalStyle />
                <NavbarComponent8 />
                <Styles>
                    <div align="center" class="container my-2">
                        <h1><b> Planilla de pagos</b></h1>
                        <a class = "btn"><button onClick={() => this.calcularPagos()}>
                            Calcular y obtener nuevos datos
                        </button></a>
                        <table border="3" class="table table-primary table-striped table-bordered border-secondary">
                            <thead class="table-dark">
                                <tr>
                                    <th>Id</th>
                                    <th>Quincena</th>
                                    <th>Codigo Proveedor</th>
                                    <th>Nombre proveedor</th>
                                    <th>Total KLS</th>
                                    <th>Nro dias</th>
                                    <th>Promedio KLS</th>
                                    <th>%Variacion Leche</th>
                                    <th>%Grasa</th>
                                    <th>%Variacion grasa</th>
                                    <th>%Solidos totales</th>
                                    <th>%Variacion ST</th>
                                    <th>Pago Leche</th>
                                    <th>Pago Grasa</th>
                                    <th>Pago ST</th>
                                    <th>Bono</th>
                                    <th>Dcto Leche</th>
                                    <th>Dcto Grasa</th>
                                    <th>Dcto ST</th>
                                    <th>Pago total</th>
                                    <th>Monto retencion</th>
                                    <th>Monto final</th>

                                </tr>
                            </thead>
                            <tbody>
                                {this.state.pagos.map((pago) => (
                                    <tr key={pago.id_pago}>
                                        <td>{pago.id_pago}</td>
                                        <td>{pago.quincena}</td>
                                        <td>{pago.codigo_proveedor}</td>
                                        <td>{pago.nombre_proveedor}</td>
                                        <td>{pago.total_kls}</td>
                                        <td>{pago.dias}</td>
                                        <td>{pago.promedio_kls}</td>
                                        <td>{pago.variacion_leche}</td>
                                        <td>{pago.grasa}</td>
                                        <td>{pago.variacion_grasa}</td>
                                        <td>{pago.solidos_totales}</td>
                                        <td>{pago.variacion_st}</td>
                                        <td>{pago.pago_leche}</td>
                                        <td>{pago.pago_grasa}</td>
                                        <td>{pago.pago_st}</td>
                                        <td>{pago.bono}</td>
                                        <td>{pago.dcto_leche}</td>
                                        <td>{pago.dcto_grasa}</td>
                                        <td>{pago.dcto_st}</td>
                                        <td>{pago.total}</td>
                                        <td>{pago.monto_retencion}</td>
                                        <td>{pago.monto_final}</td>
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

export default PagoComponent;

const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`
const Styles = styled.div`
.btn button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.btn button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
`