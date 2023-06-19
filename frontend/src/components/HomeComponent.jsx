import React, { Component } from "react";
import styled from "styled-components";
import { createGlobalStyle } from 'styled-components'
import NavbarComponent from "./NavbarComponent";
import leche from '../static/public/leche.png';

export default function Home() {

    return (
        <div>
            <GlobalStyle />
            <NavbarComponent />
            <HomeStyle>
                    {/* <header className="header">
                        <div className="logo">
                            <h1 align="center" style={{ color: "white" }}>
                                {" "}
                                <b1>MilkStgo</b1>
                            </h1>
                        </div>
                    </header> */}
                    <div align="center">
                        <a className="btn" href="/listar">
                            <button>Ver proveedores</button>
                        </a>
                        <a className="btn-2" href="/fileUpload">
                            <button>Cargar archivo de Acopio Leche</button>
                        </a>
                        <a className="btn-3" href="/fileUpload_grasa">
                            <button>Cargar archivo de Grasa y Solidos</button>
                        </a>
                        <a className="btn-4" href="/calcular">
                            <button>Calculo de pagos</button>
                        </a>
                    </div>
                    <div className="container-fluid" align="center">
                        <a className="ui-icon-image" href="#" aria-expanded="true">
                            <img src={leche} id="imagen" className="img-circle" />
                            <b className="caret" />
                        </a>
                    </div>
            </HomeStyle>
        </div>
    );
}

const GlobalStyle = createGlobalStyle`
    body { 
        background-color: lightblue;
`
const HomeStyle = styled.nav`

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
.btn-2 button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.btn-2 button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
.btn-3 button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.btn-3 button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
.btn-4 button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.btn-4 button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
img{
    height: 20%;
}
`