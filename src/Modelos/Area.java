/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author yecal
 */
public class Area {
    private String nom_area;
    private List<String> ListaArea = new ArrayList<String>();
    private List<Oficina> listaOficinas = new ArrayList<Oficina>();

    public Area(String nom_area) {
        this.nom_area = nom_area;
    }

    public String getNom_area() {
        return nom_area;
    }

    public void setNom_area(String nom_area) {
        this.nom_area = nom_area;
    }

    public List<String> getListaArea() {
        return ListaArea;
    }

    public void setListaArea(List<String> listaArea) {
        this.ListaArea = listaArea;
    }

    public List<Oficina> getListaOficinas() {
        return listaOficinas;
    }

    public void setListaOficinas(List<Oficina> listaOficinas) {
        this.listaOficinas = listaOficinas;
    }


    public void registrar_area() {
         nom_area = (JOptionPane.showInputDialog("ingrese nombre del area"));
         ListaArea.add(this.nom_area);
    }

    @Override
    public String toString() {
        return "Area{" + "nom_area=" + nom_area + ", ListaArea=" + ListaArea + ", listaOficinas=" + listaOficinas + '}';
    }
    
}
