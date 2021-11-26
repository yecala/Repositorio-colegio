/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yecal
 */
public class Persona {
    protected String identificacion;
    protected String nombres;
    protected String apellidos;
    protected String tel;

    public Persona(String identificacion, String nombres, String apellidos, String tel) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tel = tel;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
        //CREATE (CRUD)
    public void registrar_persona() throws IOException {
        this.identificacion=JOptionPane.showInputDialog("Ingrese su identificacion ");
        this.nombres = JOptionPane.showInputDialog("Ingrese el nombre ");
        this.apellidos = JOptionPane.showInputDialog("Ingrese el apellido ");
        this.tel = JOptionPane.showInputDialog("Ingrese el telefono ");
        
    }
}
