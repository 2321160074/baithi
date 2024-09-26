/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class FileHelper {
    
    public static ArrayList<String> readFileText(String fileName)
    {
        ArrayList<String> data = new ArrayList<>();        
        try {
            FileReader  fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            String line =null;
            while((line = br.readLine())!=null)
            {
                data.add(line);
            }
            
            br.close();
        } catch (Exception ex) {
            System.err.println("Error :" + ex.toString());
        }         
        return data;      
    }
    
    public static boolean writeFileText(String fileName, ArrayList<String> data)
    {       
        try {
            FileWriter  fw = new FileWriter(fileName);                           
            for(String item : data)
            {
               fw.write(item +"\n");
            }
            fw.close();
            return true;
        } catch (Exception ex) {
            System.err.println("Error :" + ex.toString());
            return false;
        }            
    }    
}
