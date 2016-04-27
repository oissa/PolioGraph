/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliointerpretation;

/**
 *
 * @author Olivia
 */
public class DataPoint {
    private Dim dim;
    private int Value;
    
    public DataPoint() {
    }
    
    public void setDim(Dim d) {
         dim = d;
    }
    
    public Dim getDim() {
        return dim;
    }
    
    public void setValue(int v) {
        Value = v;
    }
    
    public int getValue() {
        return Value;
    }
    
    @Override
    public String toString() {
        return getDim() + ": " + getValue() + "% immunized";
    }
}
