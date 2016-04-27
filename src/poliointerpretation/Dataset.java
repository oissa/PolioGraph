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
public class Dataset {
    private DataPoint[] fact;
    
    public DataPoint[] getDP(){
        return fact;
    }
    
    @Override
    public String toString(){
        String outStr = "";
        for (DataPoint d : fact){
            outStr += d.toString();
            outStr += "\n";
        }
        return outStr;
    }
}
