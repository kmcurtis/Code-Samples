/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dibya
 */
public class FileReadSortCheck {

    /**
     * @param args the command line arguments
     */
   static int[] array;

    public static void main(String[] args) {
        // TODO code application logic here
        fileRead();
        boolean result = sortCheckAsc(array);
        System.out.println(result);
        int[] a = {1,2,3,4,5};
        result = sortCheckDesc(a);
        System.out.println(result);
    }

    public static void fileRead() {
        FileInputStream fis = null;
        try {
            File f = new File("input1.txt");
            byte[] bytes = new byte[(int) f.length()];
            fis = new FileInputStream(f);
            fis.read(bytes);
            fis.close();
            String[] valueStr = new String(bytes).trim().split("\\s+");
            array = new int[valueStr.length];
            for (int i = 0; i < valueStr.length; i++) {
                array[i] = Integer.parseInt(valueStr[i]);
                System.out.println(array[i]);
            }
            System.out.println(Arrays.asList(array));
        } catch (IOException ex) {
            Logger.getLogger(FileReadSortCheck.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileReadSortCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static boolean sortCheckAsc(int[] a) {
        int  N = a.length;
        int prev = a[0];
        boolean isSorted = true;
        for(int i=1; i< N; i++){
            if(a[i] >= prev) {
                continue;
            }
            else {
                isSorted = false;
                return isSorted;
            }
        }
        return isSorted;
    }
    
    public static boolean sortCheckDesc(int[] a) {
        int  N = a.length;
        int prev = a[0];
        boolean isSorted = true;
        for(int i=1; i< N; i++){
            if(a[i] >= prev) {
                continue;
            }
            else {
                isSorted = false;
                return isSorted;
            }
        }
        return isSorted;
    }
}