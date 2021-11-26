/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yecal
 */
public class Oficina {
    private int num_oficina;
    private List<Empleado> listaEmpleados  = new ArrayList<Empleado>();   

    public Oficina(int num_oficina) {
        this.num_oficina = num_oficina;
    }

    public int getNum_oficina() {
        return num_oficina;
    }

    public void setNum_oficina(int num_oficina) {
        this.num_oficina = num_oficina;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void regitrar_oficina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
