import React from "react";
import styled from "styled-components";

function NavbarComponent() {
    return (
        <>
            <NavStyle>
                <header class="header">
                    <div class="logo">
                        <h1>MilkStgo</h1>
                    </div>
                    <nav>
                    </nav>
                    <a class="btn" href="/"><button>Volver al menú principal</button></a>
                    <a class="btn-2" href="/listar"><button>Volver al listado de Proveedores</button></a>
                </header>
            </NavStyle>
        </>
    )
}

export default NavbarComponent;

const NavStyle = styled.nav`
header{
    background-color: indigo;
}
.header{
    background-color: indigo;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    height: 85px;
    padding: 5px 10%;
}
.header .logo{
    margin-right: auto;
    color: white;
    font-family: 'arial',serif;
}
.header .btn button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.header .btn button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
.header .btn button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
.header .btn-2 button {
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    cursor: pointer;
    transition: all 0.3s ease 0s;
}
.header .btn-2 button:hover{
    background-color: #e2f1f8;
    color: #0e36ff;
    transform: matrix(1.1);
}
`