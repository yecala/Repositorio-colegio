
 
package Modelos;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 **En esta clase se registran las areas del colegio, y se asigna a cada area un codigo automatico
 * @author yecal
 */
public class Area {


    private String nom_area;
    private int ID;
    private List<Area> listaArea = new ArrayList<Area>();
    private String url;
    private String urlTemp;

    public Area(String nom_area, int ID) {
        this.nom_area = nom_area;
        this.ID = ID;
        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        url = directoryName + "/BASE DE DATOS/areaFichero.txt";
        urlTemp = directoryName + "/BASE DE DATOS/areaFicheroTemp.txt";
    }
    
    /**
     * 
     * @return Retorna el codigo del area
     */
    public int getID() {
        return ID;
    }
    
    /**
     * 
     * @param ID recibe el codigo del area
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Area> getListaArea() {
        return listaArea;
    }

    public void setListaArea(List<Area> listaArea) {
        this.listaArea = listaArea;
    }

    public String getNom_area() {
        return nom_area;
    }

    public void setNom_area(String nom_area) {
        this.nom_area = nom_area;
    }



    //CREATE (CRUD)
    public void registrar_area() throws IOException {

        nom_area = JOptionPane.showInputDialog("Ingrese el nombre del area");

        ID = consultarID() + 1;
        BufferedWriter bw = new BufferedWriter(new FileWriter(url, true));

        bw.write(ID + "," + nom_area);
        bw.flush();
        bw.newLine();
        bw.close();
        JOptionPane.showMessageDialog(null, "El area se ha registrado correctamente");
    }

    //READ (CRUD)
    public List<Area> Informe() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(url));
        this.listaArea=new ArrayList<Area>();
        String record;

        while ((record = br.readLine()) != null) {
            Area area = new Area( nom_area, ID);
            StringTokenizer st = new StringTokenizer(record, ",");
            
            area.setID(Integer.parseInt(st.nextToken()));
            area.setNom_area(st.nextToken());

            listaArea.add(area);
        }

        br.close();

        
        return listaArea;
    }

    //PARA CONECTAR CON OFICINA
    public int consultarID() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(url));

        String record;

        ID = 0;

        while ((record = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(record, ",");
            ID = Integer.parseInt(st.nextToken());

        }
        br.close();

        return ID;
    }

    //UPDATE (CRUD)
    public void Actualizar() throws IOException {
        String nuevo_nom_area, record, record2;
        boolean encontrado = false;

        File db = new File(url);
        File tempDB = new File(urlTemp);

        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));
        
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        
        String[] options = new String[Informe().size()];

      
        for (int i = 0; i < options.length; i++) {

            options[i] = Informe().get(i).getNom_area();

        }

        Object selectionObject = JOptionPane.showInputDialog(frame, "Elija el area", "Actualizar area", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        String selectionString = selectionObject.toString();
 
        BufferedReader br2 = new BufferedReader(new FileReader(db));

        while ((record2 = br2.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(record2, ",");
            StringTokenizer st2 = new StringTokenizer(record2, ",");
            st2.nextToken();

            if (st2.nextToken().equals(selectionString)) {
 
                nuevo_nom_area = JOptionPane.showInputDialog("Ingrese el nuevo nombre del area");
                bw.write(st.nextToken() + "," + nuevo_nom_area);
                encontrado = true;

            } else {

                bw.write(st.nextToken() + "," + st.nextToken());

            }
            bw.flush();
            bw.newLine();
        }

        bw.close();
        br2.close();
        db.delete();
        boolean success = tempDB.renameTo(db);

        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "Area no encontrada, intentelo de nuevo");
        } else if (success == true) {
            JOptionPane.showMessageDialog(null, " Actualizado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
    }
 
    public void eliminar() throws IOException {
        String record;
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        File tempDB = new File(urlTemp);
        File db = new File(url);

        BufferedReader br = new BufferedReader(new FileReader(db));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

        String[] options = new String[Informe().size()];
      
        for (int i = 0; i < options.length; i++) {

            options[i] = Informe().get(i).getNom_area();

        }

        Object selectionObject = JOptionPane.showInputDialog(frame, "Elija el area", "Eliminar area", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        String selectionString = selectionObject.toString();

        if (Objects.isNull(selectionString)) {
            System.out.println("opcion invalida!");
        } else {
            System.out.printf("opcion elegida: %s", selectionString);
            System.out.println();
        }

        boolean eliminado = false;

        while ((record = br.readLine()) != null) {

            if (record.contains(selectionString)) {
                eliminado = true;
                continue;
            }
            
            bw.write(record);
            bw.flush();
            bw.newLine();

        }

        br.close();
        bw.close();

        db.delete();
        tempDB.renameTo(db);

        if (eliminado == true) {
            JOptionPane.showMessageDialog(null, "Area eliminada correctamente.");

        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el area");
        }
    }
}
