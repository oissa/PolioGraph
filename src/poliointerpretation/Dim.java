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
public class Dim {
    private String PUBLISHSTATE;
    private String REGION; 
    private String GHO;
    private String WORLDBANKINCOMEGROUP;
    private int YEAR;
    private String COUNTRY;
    private String publishState;
    
    public Dim() {
    }
    
    public void setCOUNTRY(String c){
        COUNTRY = c;
    }
    
    public String getCOUNTRY(){
        return COUNTRY;
    }
    
    @Override
    public String toString() {
        return getCOUNTRY();
    }
}
