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
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author yecal
 */
public class Salon {
    private String num_salon;
    private String num_sillas;
    private String url;
    private List<Salon> listaSalon = new ArrayList<Salon>();

    public Salon( String num_salon, String num_sillas) {
        this.num_salon = num_salon;
        this.num_sillas = num_sillas;
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        url = directoryName + "/BASE DE DATOS/salonFichero.txt";
    }

    public String getNum_salon() {
        return num_salon;
    }

    public void setNum_salon(String num_salon) {
        this.num_salon = num_salon;
    }

    public String getNum_sillas() {
        return num_sillas;
    }

    public void setNum_sillas(String num_sillas) {
        this.num_sillas = num_sillas;
    }

    public void registrar_Salon() throws IOException {
        num_salon = JOptionPane.showInputDialog("Ingrese el numero del salon");
        num_sillas=JOptionPane.showInputDialog("Ingrese el numero de sillas");

        BufferedWriter bw = new BufferedWriter(new FileWriter(url, true));

        bw.write(num_salon + "," + num_sillas);
        bw.flush();
        bw.newLine();
        bw.close();

    }
  

    public List<Salon> consultar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(url));
        this.listaSalon=new ArrayList<Salon>();
        String record;

        while ((record = br.readLine()) != null) {
            Salon salon = new Salon(num_salon, num_sillas);
            StringTokenizer st = new StringTokenizer(record, ",");
            
            salon.setNum_salon(st.nextToken());
            salon.setNum_sillas(st.nextToken());
            
            listaSalon.add(salon);
        }

        br.close();

        return listaSalon;


    }
    
}