/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turing.machine;

/**
 *
 * @author Boniolo
 */
public class StatesChaining {
        
    public State getStates(){
        
        State initial = new State("a");
        State state = initial;
        state.setNext(new State("b"));
        state = state.getNext();
        state.setNext(new State("c"));
        state = state.getNext();
        state.setNext(initial);
        
        
        return initial;
    }
        
}
