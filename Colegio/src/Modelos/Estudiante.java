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
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yecal
 */
public class Estudiante extends Persona {

    private String grado;
    private String salon;
    private String url;
    private List<Estudiante> listaEstudiante = new ArrayList<Estudiante>();

    public Estudiante(String grado, String salon, String identificacion, String nombres, String apellidos, String tel) {
        super(identificacion, nombres, apellidos, tel);
        this.grado = grado;
        this.salon = salon;
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        url = directoryName + "/BASE DE DATOS/estudianteFichero.txt";
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
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

   

    public void registrar_estudiante() throws IOException {
        String num_salon="";
        String num_sillas="";
        Salon salon = new Salon(num_salon, num_sillas);
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        String[] options = new String[salon.consultar().size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = salon.consultar().get(i).getNum_salon();
        }
        Object selectionObject = JOptionPane.showInputDialog(frame, "Elija el salon al que pertenece", "Salones", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();

        for (Salon p : salon.consultar()) {
            if (p.getNum_salon().equals(selectionString)) {

                num_salon = p.getNum_salon();
                break;
            }
        }
        grado = (JOptionPane.showInputDialog("Ingrese el grado que cursa"));

        BufferedWriter bw = new BufferedWriter(new FileWriter(url, true));

        bw.write(num_salon + "," + this.identificacion + "," + this.nombres + "," + this.apellidos + "," + this.tel + "," + this.grado);
        bw.flush();
        bw.newLine();
        bw.close();
        JOptionPane.showMessageDialog(null, "El estudiante se ha registrado correctamente");
    }

    public List<Estudiante> Consultar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(url));
        this.listaEstudiante = new ArrayList<Estudiante>();
        String record;

        while ((record = br.readLine()) != null) {
            Estudiante estudiante = new Estudiante(salon, grado, identificacion, nombres, apellidos, tel);
            StringTokenizer st = new StringTokenizer(record, ",");

            estudiante.setIdentificacion(st.nextToken());

            estudiante.setNombres(st.nextToken());

            estudiante.setApellidos(st.nextToken());

            estudiante.setTel(st.nextToken());

            estudiante.setSalon(st.nextToken());

            estudiante.setGrado(st.nextToken());

            listaEstudiante.add(estudiante);
        }

        br.close();

        return listaEstudiante;
    }

   

}
