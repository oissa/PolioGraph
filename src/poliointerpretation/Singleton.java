package poliointerpretation;

import com.sun.scenario.Settings;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Olivia
 */
public class Singleton {
    public transient static Singleton instance;
    private String COUNTRY;
    private String Value;
    private String fact;
    
    private Singleton(){}
    
     public static void save() {
        init();
        try {
           FileOutputStream fileOut =
           new FileOutputStream("settings.ser"
    });
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(instance);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in settings.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }    
    
     private static void init() {
        if (instance == null) {
            try
            {
               FileInputStream fileIn = new FileInputStream("singleton.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               instance = (Singleton) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i)
            {
               instance = new Singleton();
               return;
            }catch(ClassNotFoundException c)
            {
               System.out.println("Singleton class not found");
               c.printStackTrace();
               return;
            }            
        }
    }
    public static int getValue() {
        init();
        return instance.Value;
    }
    
    public static void setFailures(Map<Integer, Integer> data) {
        init();
        instance.failedInspections = data;
    }
    
    public static String getFilterValue() {
        init();
        return instance.filterValue;
    }
    
    public static void setFilterValue(String val) {
        init();
        instance.filterValue = val;
    }
    
}
