/**
 * 
 */
package colegio;

import Modelos.Area;
import Modelos.Empleado;
import Modelos.Estudiante;
import Modelos.Oficina;
import Modelos.Persona;
import Modelos.Salon;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author yecal
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        

        int menu = 0;

        while (menu <= 5) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Areas \n 2.Oficinas \n 3. Salones \n 4. Empleados \n 5.Estudiantes \n 6.salir "));

            switch (menu) {
                case 1:

                    menu_areas();

                    break;
                case 2:

                    menu_oficinas();

                    break;
                case 3:

                    menu_salones();

                    break;

                case 4:

                    menu_empleados();

                    break;
                case 5:

                    menu_estudiantes();

                    break;

                case 6:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
            }

        }
    }

    private static void menu_areas() throws IOException {
        int menu = 0;

        String nom_area = "";
        List<Area> listaArea = new ArrayList<Area>();
        
        int ID=0;
        Area area = new Area(nom_area, ID);

        while (menu < 5) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Registrar area \n 2.informe areas \n 3. actualizar area \n 4. eliminar area \n 5. volver al menu anterior"));

            switch (menu) {
                case 1:

                    area.registrar_area();

                    break;
                case 2:

                    listaArea = area.Informe();

                    StringBuilder builder = new StringBuilder("<html>");
                    for (Area a : listaArea) {
                        builder.append(a.getID() + "." + a.getNom_area());
                        builder.append("<br>");
                    }
                    builder.append("</html>");
                    JOptionPane.showMessageDialog(null, builder.toString(), "AREAS", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 3:

                    area.Actualizar();

                    break;

                case 4:

                    area.eliminar();

                    break;

                case 5:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;

            }

        }
    }

    private static void menu_oficinas() throws IOException {
        int menu = 0;
        String num_oficina = " ";
        String nom_area = "";
        int ID=0;
        Oficina oficina = new Oficina(num_oficina,  nom_area,  ID);

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Registrar oficina \n 2.informe oficina \n 3. volver al menu anterior"));

            switch (menu) {
                case 1:

                    oficina.registrar_oficina();

                    break;
                case 2:

                    List<Oficina> listaOficinas = new ArrayList<Oficina>();

                    listaOficinas = oficina.InformeOficina();
                 
                    
                    Collections.sort(listaOficinas, new Comparator<Oficina>() {
                        @Override
                        public int compare(Oficina o1, Oficina o2) {
                            return o1.getNom_area().compareToIgnoreCase(o2.getNom_area());
                        }
                    });
                    List<String> listaOficinaStr = new ArrayList<String>();
                    
                    for(Oficina ofi:listaOficinas ){
                        
                        listaOficinaStr.add(ofi.getNom_area()+": "+ ofi.getNum_oficina());
                    
                    }
                    
                    
                    /*Collections.sort(listaOficinas);*/

                    JPanel panel = new JPanel(new BorderLayout(10, 10));
                    String text = "Oficinas";
                    JLabel label = new JLabel(text);
                    panel.add(label, BorderLayout.PAGE_START);
                    String[] str = new String[listaOficinaStr.size()];
                    JList<String> list = new JList<>(listaOficinaStr.toArray(str));
                    panel.add(list, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(null, panel, "Informe", JOptionPane.INFORMATION_MESSAGE);

                    listaOficinaStr = null;

                    break;
               case 3:

                    break;


                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
            }

        }
    }

    private static void menu_salones() throws IOException {
        int menu = 0;

        String num_salon = "";
        String num_sillas = "";

        Salon salon = new Salon(num_salon, num_sillas);

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Registrar Salon \n 2.informe Salon \n 3. volver al menu anterior"));

            switch (menu) {
                case 1:

                    salon.registrar_Salon();

                    break;
                case 2:
                    List<Salon> listaSalon = new ArrayList<Salon>();

                    listaSalon=salon.consultar();
                    
                    Collections.sort(listaSalon, new Comparator<Salon>() {
                        
                        public int compare(Salon o1, Salon o2) {
                            return o1.getNum_salon().compareToIgnoreCase(o2.getNum_salon());
                        }
                    });
                    List<String> listaSalonstr = new ArrayList<String>();
                    
                    for(Salon s:listaSalon ){
                        
                        listaSalonstr.add(s.getNum_salon()+": "+ s.getNum_sillas());
                    
                    }

                    JPanel panel = new JPanel(new BorderLayout(10, 10));
                    String text = "Salones";
                    JLabel label = new JLabel(text);
                    panel.add(label, BorderLayout.PAGE_START);
                    String[] str = new String[listaSalonstr.size()];
                    JList<String> list = new JList<>(listaSalonstr.toArray(str));
                    panel.add(list, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(null, panel, "Informe", JOptionPane.INFORMATION_MESSAGE);

                    break;
                    
                case 3:
                  

                    break;
                   
                
               
                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
                    
                
            }

        }
    }

    private static void menu_empleados() throws IOException {
        int menu = 0;
        String tipo_empleado = null;
        String tipo_contrato = null;
        String identificacion = null;
        String nombres = null;
        String apellidos = null;
        String tel = null;


        Empleado empleado = new Empleado(tipo_empleado, tipo_contrato, identificacion, nombres, apellidos, tel);

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Registrar empelado \n 2.informe empleado \n 3. volver al menu anterior"));

            switch (menu) {
                case 1:

                    empleado.registrar_persona();
                    empleado.registrar_empleado();

                    break;
                case 2:
                    List<Empleado> listaEmpleado = new ArrayList<Empleado>();
                    listaEmpleado=empleado.Informe();
                    
                    Collections.sort(listaEmpleado, new Comparator<Empleado>() {
                        
                        public int compare(Empleado o1, Empleado o2) {
                            return o1.getNum_oficina().compareToIgnoreCase(o2.getNum_oficina());
                        }
                    });
                    List<String> listaEmpleadostr = new ArrayList<String>();
                    
                    for(Empleado emple:listaEmpleado ){
                        
                        listaEmpleadostr.add(emple.getNum_oficina()+": "+ emple.getIdentificacion()+", "+ emple.getNombres()+", "+ emple.getApellidos()+", "+ emple.getTel()+", "+ emple.getTipo_empleado()+", "+ emple.getTipo_contrato());
                    
                    }
                    
                    
                    /*Collections.sort(listaOficinas);*/

                    JPanel panel = new JPanel(new BorderLayout(10, 10));
                    String text = "Empleados";
                    JLabel label = new JLabel(text);
                    panel.add(label, BorderLayout.PAGE_START);
                    String[] str = new String[listaEmpleadostr.size()];
                    JList<String> list = new JList<>(listaEmpleadostr.toArray(str));
                    panel.add(list, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(null, panel, "Informe", JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 3:
                    
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
            }
        }
    }

    private static void menu_estudiantes() throws IOException {
        int menu = 0;

        String identificacion = null;
        String nombres = null;
        String apellidos = null;
        String tel = null;
        String grado = null;
        String n_salon = null;

        Estudiante estudiante = new Estudiante(grado, n_salon, identificacion, nombres, apellidos, tel);

        while (menu < 3) {

            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. Registrar estudiante \n 2.informe estudiante \n 3.volver al menu anterior"));

            switch (menu) {
                case 1:
                    
                    estudiante.registrar_persona();
                    
                    estudiante.registrar_estudiante();

                    break;
                case 2:
                    List<Estudiante> listaEstudiante = new ArrayList<Estudiante>();
                    listaEstudiante=estudiante.Consultar();
                    
                    
                    Collections.sort(listaEstudiante, new Comparator<Estudiante>() {
                        
                       public int compare(Estudiante o1, Estudiante o2) {
                            return o1.getSalon().compareToIgnoreCase(o2.getSalon());
                        }
                    });
                    List<String> listaEstudiantestr = new ArrayList<String>();
                    
                    for(Estudiante estud:listaEstudiante ){
                        
                        listaEstudiantestr.add(estud.getIdentificacion()+", "+ estud.getNombres()+", "+ estud.getApellidos()+", "+ estud.getTel() + ", " + estud.getSalon() +", "+  estud.getGrado());
                    
                    }
                    
                    
                    /*Collections.sort(listaOficinas);*/

                    JPanel panel = new JPanel(new BorderLayout(10, 10));
                    String text = "Estudiantes";
                    JLabel label = new JLabel(text);
                    panel.add(label, BorderLayout.PAGE_START);
                    String[] str = new String[listaEstudiantestr.size()];
                    JList<String> list = new JList<>(listaEstudiantestr.toArray(str));
                    panel.add(list, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(null, panel, "Consultar", JOptionPane.INFORMATION_MESSAGE);


                    break;
                case 3:

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
            }
        }
    }
}
