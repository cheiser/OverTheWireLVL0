/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Krypto;

/**
 *
 * @author Mattis
 */
public class FrequencyLetter {
    private String letter;
    private int count;
    private double frequency; // stored in procent as a double so if it occurs for example 10% of the time this would be 0.1
    
    public FrequencyLetter(String letter){
        this.letter = letter;
        this.count = 0;
    }
    
    public void addOne(){
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getLetter() {
        return letter;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    
    
    
    
}
