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
public class State {
    private String c;
    private State next = null;
    private State prev = null;

    public State getPrev() {
        return prev;
    }

    public void setPrev(State prev) {
        this.prev = prev;
    }
    
    public State(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }

    public State getNext() {
        return next;
    }

    public void setNext(State next) {
        this.next = next;
    }
    
    
}
