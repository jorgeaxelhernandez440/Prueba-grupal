package com.example.pruebagrupal.Model;

import java.util.ArrayList;

// Clase para poder obtener la respuesta del servicio de clientes
// Es para crear un objeto que contiene una lista de objetos tipo cliente

public class UsuarioList {
    private ArrayList<UsuarioModel> usuario;

    public UsuarioList(ArrayList<UsuarioModel> usuario) {
        this.usuario = usuario;
    }

    public ArrayList<UsuarioModel> getClienteList() {
        return usuario;
    }
}
