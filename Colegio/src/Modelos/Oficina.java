/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Modelos.Area;
import java.awt.BorderLayout;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author yecal
 */
public class Oficina extends Area {

    private String num_oficina;
    private String url;
    private List<Oficina> listaOficinas = new ArrayList<Oficina>();

    public Oficina(String num_oficina, String nom_area, int ID) {
        super(nom_area, ID);
        this.num_oficina = num_oficina;
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        url = directoryName + "/BASE DE DATOS/oficinaFichero.txt";
    }

    public String getNum_oficina() {
        return num_oficina;
    }

    public List<Oficina> getListaOficinas() {
        return listaOficinas;
    }

    public void setListaOficinas(List<Oficina> listaOficinas) {
        this.listaOficinas = listaOficinas;
    }

    public void setNum_oficina(String num_oficina) {
        this.num_oficina = num_oficina;
    }

 

    public boolean existeOficina() throws IOException {
        boolean existeOficina = false;

        BufferedReader br = new BufferedReader(new FileReader(url));
        String record;

        while ((record = br.readLine()) != null) {
            if (record.contains(num_oficina)) {
                existeOficina = true;

            }
        }

        return existeOficina;
    }

    public void registrar_oficina() throws IOException {
        
        boolean existeOficina = false;

        String nom_area = "";
        int ID = 0;
        Area area = new Area(nom_area, ID);

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        String[] options = new String[area.Informe().size()];
        for (int i = 0; i < options.length; i++) {
            options[i] = area.Informe().get(i).getNom_area();

        }

        Object selectionObject = JOptionPane.showInputDialog(frame, "Elija el area al que pertenece la oficina", "Oficinas", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String selectionString = selectionObject.toString();

        int idArea = 0;

        for (Area p : area.Informe()) {
            if (p.getNom_area().equals(selectionString)) {
                idArea = p.getID();
                nom_area = p.getNom_area();
                break;

            }
        }

        num_oficina = JOptionPane.showInputDialog("Ingrese el numero de la oficina");

        existeOficina = existeOficina();

        while (existeOficina == true) {

            num_oficina = JOptionPane.showInputDialog("El numero de oficina ya existe, por favor ingrese un nuevo numero");
            existeOficina = existeOficina();
        }

        BufferedReader br = new BufferedReader(new FileReader(url));
        String record;

        BufferedWriter bw = new BufferedWriter(new FileWriter(url, true));

        
        bw.write(idArea + "," + nom_area + "," + num_oficina);

        bw.flush();
        bw.newLine();
        bw.close();
    }

    public List<Oficina> InformeOficina() throws IOException {
        String nom_area = "";
        int ID = 0;
        //listaOficinas=null;
        BufferedReader br = new BufferedReader(new FileReader(url));
        this.listaOficinas = new ArrayList<Oficina>();

        String record = "";

        while ((record = br.readLine()) != null) {

            Oficina oficina = new Oficina(num_oficina, nom_area, ID);

            StringTokenizer st = new StringTokenizer(record, ",");

            st.nextToken();

            oficina.setNom_area(st.nextToken());
            oficina.setNum_oficina(st.nextToken());

            listaOficinas.add(oficina);

        }

        br.close();

        return listaOficinas;
    }

   

}
