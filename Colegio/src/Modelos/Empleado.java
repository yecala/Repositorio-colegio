/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
public class Empleado extends Persona {

    private String tipo_empleado;
    private String tipo_contrato;
    private String url;
    private String num_oficina;
    private List<Empleado> listaEmpleado = new ArrayList<Empleado>();

    public Empleado(String tipo_empleado, String tipo_contrato, String identificacion, String nombres, String apellidos, String tel) {
        super(identificacion, nombres, apellidos, tel);
        this.tipo_empleado = tipo_empleado;
        this.tipo_contrato = tipo_contrato;
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        url = directoryName + "/BASE DE DATOS/empleadoFichero.txt";
    }

    public String getTipo_empleado() {
        return tipo_empleado;
    }

    public String getNum_oficina() {
        return num_oficina;
    }

    public void setNum_oficina(String num_oficina) {
        this.num_oficina = num_oficina;
    }

    public void setTipo_empleado(String tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }


    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleado> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
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




    public void registrar_empleado() throws IOException {
        String num_oficina = "";
        String nom_area="";
        int ID=0;
        Oficina oficina = new Oficina(num_oficina,  nom_area,  ID);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        String[] options = new String[oficina.InformeOficina().size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = oficina.InformeOficina().get(i).getNum_oficina();
        }
        Object selectionObject = JOptionPane.showInputDialog(frame, "Elija la oficina a la que pertenece", "Oficinas", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();

        for (Oficina p : oficina.InformeOficina()) {
            if (p.getNum_oficina().equals(selectionString)) {
                
                num_oficina = p.getNum_oficina();
                break;
            }
        }
        tipo_contrato = JOptionPane.showInputDialog("Ingrese el tipo de contrato");
        tipo_empleado = JOptionPane.showInputDialog("Ingrese el tipo de empleado");

        BufferedWriter bw = new BufferedWriter(new FileWriter(url, true));

        bw.write(num_oficina+ ","+ this.identificacion + "," + this.nombres + "," + this.apellidos + "," + this.tel  + "," +this.tipo_contrato + "," + this.tipo_empleado);
        bw.flush();
        bw.newLine();
        bw.close();
        JOptionPane.showMessageDialog(null, "El empleado se ha registrado correctamente");
    }

    public List<Empleado> Informe() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(url));
        this.listaEmpleado = new ArrayList<Empleado>();
        String record;

        while ((record = br.readLine()) != null) {
            Empleado empleado = new Empleado(  tipo_empleado,tipo_contrato, identificacion,  nombres,  apellidos,  tel);
            StringTokenizer st = new StringTokenizer(record, ",");
            
            empleado.setNum_oficina(st.nextToken());

            empleado.setIdentificacion(st.nextToken());

            empleado.setNombres(st.nextToken());

            empleado.setApellidos(st.nextToken());

            empleado.setTel(st.nextToken());
            
            empleado.setTipo_contrato(st.nextToken());
            
            empleado.setTipo_empleado(st.nextToken());

            listaEmpleado.add(empleado);
        }

        br.close();

        return listaEmpleado;
    }

   
    

}
