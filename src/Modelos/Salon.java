/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author yecal
 */
public class Salon {
    private int num_salon;
    private int num_sillas;

    public Salon(int num_salon, int num_sillas) {
        this.num_salon = num_salon;
        this.num_sillas = num_sillas;
    }

    public int getNum_salon() {
        return num_salon;
    }

    public void setNum_salon(int num_salon) {
        this.num_salon = num_salon;
    }

    public int getNum_sillas() {
        return num_sillas;
    }

    public void setNum_sillas(int num_sillas) {
        this.num_sillas = num_sillas;
    }
    
    
}
