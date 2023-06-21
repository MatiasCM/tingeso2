import React, { Component } from "react";
import NavbarComponent7 from "./NavbarComponent7";
import styled from "styled-components";
import { createGlobalStyle } from 'styled-components'

class GrasaInformationComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
        };
    }

    componentDidMount() {
        fetch("http://localhost:8080/grasas")
            .then((response) => response.json())
            .then((data) => this.setState({ data: data }));
    }

    render() {
        return (
            <div>
                <GlobalStyle />
                <NavbarComponent7 />
                <Styles>
                    <div align="center" class="container my-2">
                        <h1><b> Listado de Grasas y Solidos</b></h1>
                        <table border="3" class="table table-primary table-striped table-bordered border-secondary">
                            <thead class="table-dark">
                                <tr>
                                    <th>Proveedor</th>
                                    <th>Grasa</th>
                                    <th>Solido</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.data.map((grasa) => (
                                    <tr>
                                        <td>{grasa.proveedor}</td>
                                        <td>{grasa.grasa}</td>
                                        <td>{grasa.solido}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                </Styles>
            </div>

        );
    }
}

export default GrasaInformationComponent;

const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`
const Styles = styled.div`
`