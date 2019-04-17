/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormat;

/**
 *
 * @author Aluno
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DecimalFormat df = new DecimalFormat("###.00");
       double total  = 500;
       double a = 280;
       double b = 120;
       double c = 100;
       
       
       
       
   
       
       
        System.out.println("A" + df.format((a  / total) *100));
        System.out.println("B" + (b  / total) *100);
        System.out.println("A" + (c  / total) *100);
    }
    
}
