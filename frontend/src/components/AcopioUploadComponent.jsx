import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import NavbarComponent4 from "./NavbarComponent4";
import AcopioService from "../services/AcopioService";
import styled from "styled-components";
import swal from 'sweetalert';
import { createGlobalStyle } from 'styled-components'

class AcopioUploadComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            file: null,
        };
        this.onFileChange = this.onFileChange.bind(this);
    }

    onFileChange(event) {
        this.setState({ file: event.target.files[0] });
    }

    onFileUpload = () => {
        swal({
            title: "¿Está seguro de que desea cargar el archivo de texto?",
            text: "Tenga en cuenta que el archivo solo será cargado si su formato es correcto.",
            icon: "warning",
            buttons: ["Cancelar", "Cargar"],
            dangerMode: true
        }).then(respuesta => {
            if (respuesta) {
                swal("Archivo cargado correctamente!", { icon: "success", timer: "3000" });
                const formData = new FormData();
                formData.append("file", this.state.file);
                AcopioService.guardarData(formData).then((res) => {
                });
            }
            else {
                swal({ text: "Archivo no cargado.", icon: "error" });
            }
        });
    };

    render() {
        return (
            <div>
                <GlobalStyle />
                <NavbarComponent4 />
                <Styles>
                    <div class="f">
                        <div class="container">
                            <h1><b>Cargar el archivo de datos</b></h1>
                            <Row className="mt-4">
                                <Col col="12">
                                    <Form.Group className="mb-3" controlId="formFileLg">
                                        <Form.Control type="file" size="lg" onChange={this.onFileChange} />
                                    </Form.Group>
                                    <Button varian="primary" onClick={this.onFileUpload}>
                                        Cargar el archivo a la Base de Datos</Button>
                                </Col>
                            </Row>
                        </div>
                    </div>
                    <br>
                    </br>
                    <hr>
                    </hr>
                </Styles>
            </div>
        );
    }
}

export default AcopioUploadComponent;

const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`
const Styles = styled.div`
.container{
    display: flex;
    flex-direction: column;
    align-items: center;
}
`