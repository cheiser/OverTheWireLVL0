/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Krypto;

import java.util.HashMap;

/**
 *
 * @author Mattis
 */
public class FrequencyTable {

    private FrequencyLetter[] table;
    private FrequencyLetter[] sorted;
    private static int numberOfLetters = 26;
    private FrequencyLetter[] englishFrequency;
    private boolean isSorted = false;

    public FrequencyTable() {
        initializeTable();
        initializeEnglishTable();
    }

    private void initializeTable() {
        table = new FrequencyLetter[FrequencyTable.numberOfLetters];

        for (int i = 0; i < table.length; i++) {
            table[i] = new FrequencyLetter("" + (char) (65 + i));
        }
    }

    private void initializeEnglishTable() {
        englishFrequency = new FrequencyLetter[26];

        for (int i = 0; i < englishFrequency.length; i++) {
            englishFrequency[i] = new FrequencyLetter("" + (char) (i + 65));
            englishFrequency[i].setFrequency(FrequencyTable.getEnglishFrequency(i));
        }
    }

    public void getMostLikely() {
        FrequencyLetter[] sortedEnglish = sortTableFrequency(englishFrequency);

        for (int i = 0; i < sortedEnglish.length; i++) {
            System.out.println(this.getNthFrequent(i + 1).getLetter() + " is probably a " + sortedEnglish[i].getLetter());
        }
    }

    /**
     * tempString is the string to be converted using the most likely characters
     * used by the analysis
     *
     * accepts only uppercase letters
     *
     * @param tempString
     * @return
     */
    public String getMostLikely(String tempString) {
        FrequencyLetter[] sortedEnglish = sortTableFrequency(englishFrequency);
        
        HashMap<String, String> translationTable = new HashMap<String, String>(); // the key is the character we got and the value
        // is the most likely character it really is
        
        for (int i = 0; i < sortedEnglish.length; i++) {
            System.out.println(this.getNthFrequent(i + 1).getLetter() + " is probably a " + sortedEnglish[i].getLetter());
            translationTable.put(this.getNthFrequent(i + 1).getLetter(), sortedEnglish[i].getLetter());
        }
        System.out.println("");
        System.out.println("");


        String temp = "";

        for (int i = 0; i < tempString.length(); i++) {
            if (tempString.charAt(i) >= 65 && tempString.charAt(i) <= 90) {
                
                temp = temp + translationTable.get("" + tempString.charAt(i));
            }
        }

        return temp;
    }
    

    public void addToCount(String letter) {
        isSorted = false;
        int place = letter.charAt(0);
        table[place].addOne();
    }

    public void addToCount(char letter) {
        isSorted = false;
        table[letter - 65].addOne();
    }

    public static double getEnglishFrequency(int letter) {
        switch (letter) {
            case 0:
                return 0.08167; // A
            case 1:
                return 0.01492; // B
            case 2:
                return 0.02780; // C
            case 3:
                return 0.04253; // D
            case 4:
                return 0.12702; // E
            case 5:
                return 0.02288; // F
            case 6:
                return 0.02022; // G
            case 7:
                return 0.06094; // H
            case 8:
                return 0.06973; // I
            case 9:
                return 0.00150; // J
            case 10:
                return 0.00747; // K
            case 11:
                return 0.04025; // L
            case 12:
                return 0.02517; // M
            case 13:
                return 0.06749; // N
            case 14:
                return 0.07507; // O
            case 15:
                return 0.01929; // P
            case 16:
                return 0.00098; // Q
            case 17:
                return 0.05987; // R
            case 18:
                return 0.06333; // S
            case 19:
                return 0.09056; // T
            case 20:
                return 0.02758; // U
            case 21:
                return 0.01037; // V
            case 22:
                return 0.02465; // W
            case 23:
                return 0.00153; // X
            case 24:
                return 0.01971; // Y
            case 25:
                return 0.00074; // Z
            default:
                System.out.println("cant find that one");
                return 0;

        }
    }

    /**
     * Nth frequent is that 1 is the most frequent 2 is the second most frequent
     * and so on
     *
     * @param n
     * @throws ArrayIndexOutOfBoundsException
     */
    public FrequencyLetter getNthFrequent(int n) {
        if (!isSorted) {
            sortTable();
        }
        return sorted[n - 1];
    }

    private void sortTable() {
        isSorted = true;

        sorted = new FrequencyLetter[table.length];
        for (int i = 0; i < table.length; i++) {
            sorted[i] = table[i];
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = i + 1; j < table.length; j++) {
                if (sorted[i].getCount() < sorted[j].getCount()) {
                    FrequencyLetter temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
    }

    private FrequencyLetter[] sortTableFrequency(FrequencyLetter[] sort) {

        FrequencyLetter[] sortTable = new FrequencyLetter[sort.length];
        for (int i = 0; i < sort.length; i++) {
            sortTable[i] = sort[i];
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = i + 1; j < table.length; j++) {
                if (sortTable[i].getFrequency() < sortTable[j].getFrequency()) {
                    FrequencyLetter temp = sortTable[i];
                    sortTable[i] = sortTable[j];
                    sortTable[j] = temp;
                }
            }
        }

        return sortTable;
    }
}
