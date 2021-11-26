/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import Modelos.Area;
import Modelos.Empleado;
import Modelos.Estudiante;
import Modelos.Oficina;
import Modelos.Salon;
import javax.swing.JOptionPane;

/**
 *
 * @author yecal
 */
public class Colegio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu = 0;

        float altura = 0;
        float resultado = 0;
        float radio = 0;
        String nom_area = null;
        int num_oficina = 0;
        String tipo_empleado = null;
        String tipo_contrato = null;
        int identificacion = 0;
        String nombres = null;
        String apellidos = null;
        int tel=0;
        int grado=0;
        int n_salon=0;
        int num_salon=0;
        int num_sillas=0;
        
        Area area = new Area(nom_area);
        Oficina oficina = new Oficina(num_oficina);
        Empleado empleado = new Empleado(tipo_empleado, tipo_contrato, identificacion, nombres, apellidos, tel);
        Estudiante estudiante = new Estudiante( grado, n_salon, identificacion, nombres, apellidos, tel);
        Salon salon = new Salon(num_salon, num_sillas);
        
        while (menu <= 5) {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu: \n 1. registgre area  \n 2. registrar oficina \n 3. registrar empleado \n 4.Mostrar lista \n "));
            switch (menu) {
                case 1:

                    area.registrar_area();
                    

                    break;
                case 2:

                    oficina.regitrar_oficina();

                    break;
                case 3:

                    empleado.registrar_empleado();

                    break;
                
                case 4:
                    JOptionPane.showMessageDialog(null, area.toString());
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "No existe esa opcion de menu. ");
                    break;
            }

        }
    }

}
