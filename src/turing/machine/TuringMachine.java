/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Boniolo
 */
public class TuringMachine {
    
    private List<String> fita;
    private JLabel state1;
    private JLabel state2;
    private JLabel state3;
    private JLabel monitor;  

    public TuringMachine(List<String> fita, JLabel state1, JLabel state2, JLabel state3, JLabel monitor) {
        this.fita = fita;
        this.state1 = state1;
        this.state2 = state2;
        this.state3 = state3;
        this.monitor = monitor;
    }
    
    
    
    public boolean run(){
        
        this.fita = fita;
        
        State state = new StatesChaining().getStates();
        
        
        List<String> sentence = new ArrayList<String>();;
        
        
        fita.forEach((x)->{
            sentence.add(x);
                   
        });
        
        
        
        int i = 0;
        
        for(int j = 0; j < (fita.size()/3); j++){
            
            while(fita.get(i).equals("X"))
                i++;
            
            if(fita.get(i).equals(state.getC())){
                
                fita.set(i, "X");
                
                this.refresh(this.fita);
                
                state = state.getNext();
                
                state1.setText("A");
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}
                
                state1.setText("state 1");
            }
            try {
                while(fita.get(i).equals("a") || fita.get(i).equals("X")){
                i++;
                }
            } catch (IndexOutOfBoundsException ex ) {
                return false;
            }
            
            
            if(fita.get(i).equals(state.getC())){
                
                fita.set(i, "X");
                
                this.refresh(this.fita);
                
                state = state.getNext();
                
                state2.setText("B");
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {}
                state2.setText("state 2");                
            }
            try {
                while(fita.get(i).equals("b") || fita.get(i).equals("X")){
                i++;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
            
            
            if(fita.get(i).equals(state.getC())){
                fita.set(i, "X");
                
                this.refresh(this.fita);
                
                
                state = state.getNext();
                
                state3.setText("C");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TuringMachine.class.getName()).log(Level.SEVERE, null, ex);
                }
                state3.setText("state 3");
                
                try{
                    while(fita.get(i).equals("X") || fita.get(i).equals("a") || fita.get(i).equals("b"))
                        i--;
                }catch(IndexOutOfBoundsException ex){
                    System.out.println("Branco alcançado");
                    i = 0;
                }
                
            }
        }
             
                
        
        fita.forEach((x)->{
            System.out.print(x+" ");
        });
        
        System.out.println("");
        
        sentence.forEach((x)->{
            System.out.print(x+" ");
        });
       
        for (int b = 0; b < fita.size(); b++)
            if(!fita.get(b).equals("X"))
               return false;
        return true;
        
    }
    
    private void refresh(List<String> fita){
        
        String sentence = "";
        for (String x : fita) {
            sentence = sentence.concat(x);
        }
        
        this.monitor.setText(sentence);
        
        
    }
    
}
