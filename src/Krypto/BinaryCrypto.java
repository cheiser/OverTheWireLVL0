/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Krypto;

import java.util.ArrayList;

/**
 *
 * @author Mattis
 */
public class BinaryCrypto {
    
    public static void main(String[] args){
        System.out.println(BinaryCrypto.binaryToText(BinaryCrypto.getBinaryNumbers("31 30 31 31 31 31 30 30 "
                + "30 30 31 30 31 31 31 30 30 31 30 31 30 30 31 30 31 31 31 31 30 31 31 30 "
                + "31 30 31 30 30 31 31 30 31 30 30 30 30 30 31 30 31 31 30 31 30 30 31 30 "
                + "31 30 31 31 30 30 31 30 31 31 30 30 30 31 31 30 31 31 31 31 30 30 31 30 "
                + "30 30 30 30 31 30 31 30 30 31 31 31 30 31 31 30 30 31 31 30 31 31 31 30 "
                + "31 30 30 30 30 30 31 30 30 31 30 31 31 31 31 30 31 30 30 30 31 31 31 30 "
                + "30 30 31 30 31 31 31 30 30 30 31 30 31 31 31 30 30 30 31 30 31 30 31 30 "
                + "30 30 30 30 31 31 31 30 30 30 30 31 31 31 31 30 31 30 31 30 30 30 31 30 "
                + "30 30 30 30 31 31 30 30 30 30 31 31 30 30 31 30")));
    }
    
    public static ArrayList<Boolean> getBinaryNumbers(String boolString){
        ArrayList<Boolean> temp = new ArrayList<Boolean>();
        for(int i = 0; i < boolString.length(); i++){
            if(boolString.charAt(i) == '1'){
                temp.add(Boolean.TRUE);
            } else if(boolString.charAt(i) == '0'){
                temp.add(Boolean.FALSE);
            }
        }
        return temp;
    }
    
    public static String binaryToText(ArrayList<Boolean> boolString){
        String boolText = "";
        
        if(boolString.size()%8 != 0){
            System.out.println("not divisible by eight");
            return null;
        }
        
        int i = 0;
        while(i < boolString.size()){
            int number = 0;
            for(int j = 0; j < 8; j++){ // 2^(8-0(0 is j)), 2^(8-1 (1 is j)) osv...
                if(boolString.get(i) == true){ // if it is a one then one should add 1*(2^j) to the total sum
                    number += Math.pow(2, 7-j); // 7 because it starts a 2^0 and then increases with one up to 7 (2^0, 2^1 osv...)
                }
                i++;
            }
            boolText = boolText + getNumbersChar(number);
        }
        
        
        return boolText;
    }
    
    public static ArrayList<Boolean> textToBinary(String text){
        ArrayList<Boolean> boolArray = new ArrayList<Boolean>();
        for(int i = 0; i < text.length(); i++){
            int number = text.charAt(i);
            for(int j = 0; j < 8; j++){
                if(number-Math.pow(2, 7-j) >= 0){
                    boolArray.add(Boolean.TRUE);
                    number -= Math.pow(2, 7-j);
                } else{
                    boolArray.add(Boolean.FALSE);
                }
            }
        }
        return boolArray;
    }
    
    public static char getNumbersChar(int number){
        char character = (char)number;
        
        return character;
    }
}
