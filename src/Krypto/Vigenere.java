/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Krypto;

/**
 *
 * @author Mattis
 */

/*
 * TODO's:
 * Fixa så att man kan testa även med dem näst troligaste(osv.) shiftsen
 */
public class Vigenere {

    public static void main(String[] args) {
        // System.out.println(Vigenere.ceasarShiftN("ABCDE", 1));
//        String[] test = Vigenere.partitionString("testarlite", 5);
//        System.out.println(test[0] + "  " + test[1]);
        // System.out.println(Vigenere.encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", "B"));
        
        String temp = Vigenere.encrypt("HELLOMYNAMEISMATTISANDIAMFUCKINGGREATATLEASTSOMETIMESMAYBEIAMTRYINGTOWRITEALONGASSTEXTBUTITDOESNOT"
                + "SEEMTOBECOMEVERYLONGATALLBUTMAYBEITWILLWORKANYWAYBUTITWILLPROBABLYNOTANDNOWTHEFREAKINGFIREFOXMASTERPASSWORDPIECEOF"
                + "SHITWONTWORKEITHERPIECEOFSHITWELLWELLCANTBEMADABOUTTHATKINDOFSHITALLDAY", "FORTH");
        System.out.println(temp);
        Vigenere.determinateKeyLength(temp, 1, 7);
        System.out.println(Vigenere.crackVigenere(temp, 5, 6));/**/
        
        
        /* String temp = Vigenere.encrypt("AVERYLONGTESTTEXTWRITTENFORTHESOULPURPOSEOFTESTINGBUTMAYBETHETESTWONT"
                + "WORKVERYWELLBUTIFTHATISTHECASETHENIWILLBEPRETTYSADANDFRUSTRATEDBUTASIWASWRITTINGIAMTRYINGTO"
                + "GETALONGASSTEXTBUTMAYBEITWONTBECOMEVERYLONGSOIDONTREALLYKNOWWHATTOWRITE", "RANDOM");
        System.out.println(temp);
        Vigenere.determinateKeyLength(temp, 1, 7);
        System.out.println(Vigenere.crackVigenere(temp, 6, 7));
        
        /* String forCrypto = "DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE CDTYO SZSKY UYQEK "
                + "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO ZIPML YQEHR GZYOD KILAQ LTVSU "
                + "GCXUO AOKAV RHVKX NTQBL AFKSL QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU "
                + "ANVJA RCHNF ZYORO YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX ";
        
        for(int i = 2; i < 15; i++){
            System.out.println("i = " + i);
            System.out.println(Vigenere.crackVigenere(forCrypto, i, i+1));
        }
        
        
        
        /* System.out.println(crackVigenere("DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE CDTYO SZSKY UYQEK " +
                "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO ZIPML YQEHR GZYOD KILAQ LTVSU " +
                "GCXUO AOKAV RHVKX NTQBL AFKSL QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU " +
                "ANVJA RCHNF ZYORO YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX " +
                "DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE CDTYO SZSKY UYQEK " +
                "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO ZIPML YQEHR GZYOD KILAQ LTVSU " +
                "GCXUO AOKAV RHVKX NTQBL AFKSL QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU " +
                "ANVJA RCHNF ZYORO YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX " +
                "DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE CDTYO SZSKY UYQEK " +
                "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO ZIPML YQEHR GZYOD KILAQ LTVSU " +
                "GCXUO AOKAV RHVKX NTQBL AFKSL QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU " +
                "ANVJA RCHNF ZYORO YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX " +
                "DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE CDTYO SZSKY UYQEK " +
                "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO ZIPML YQEHR GZYOD KILAQ LTVSU " +
                "GCXUO AOKAV RHVKX NTQBL AFKSL QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU " +
                "ANVJA RCHNF ZYORO YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX ", 2, 12));
        /*
         * int key = determinateKeyLength("DAADV GQIVU CBLFW MRIPQ ZMCBA YQEIE
         * CDTYO SZSKY UYQEK " + "EUOYV GKIII PBCMS UGIYS DUDHR UYNOI OAOPO
         * ZIPML YQEHR GZYOD KILAQ LTVSU " + "GCXUO AOKAV RHVKX NTQBL AFKSL
         * QPAHK CZOLE ZTRKZ TGDOI UGOON OTEUC HGGSU " + "ANVJA RCHNF ZYORO
         * YLACW AEOKI PDVTJ OAEZD IOZDV PCCZT JSZMK CZIQX ", 8, 11);
         * System.out.println("key length = " + key);
         /*System.out.println(shiftLetters("abcdef", 2));
         System.out.println(encrypt("abc", "abc"));
         System.out.println(decrypt(encrypt("testarlite", "abc"), "abc"));
         /**/
    }

    /*
     * encrypts an text by shifting letters forwards by the amount given by the
     * relevant letter in the key text eg. if i got the the text "abc" and use
     * the key "a" the resulting encrypted text becomes "bcd" of if i got the
     * text "abc" and use the key "abc" the resulting encrypted text becomes
     * "bdf" as b(2) = a(1)+a(1) and d(4) = b(2)+b(2) and f(6) = c(3)+c(3)
     */
    public static String encrypt(String text, String key) {
        String encrypted = "";
        int textIndex = 0;

        while (textIndex < text.length()) {
            for (int i = 0; (i < key.length()) && (textIndex < text.length()); i++) {
                if (text.charAt(textIndex) >= 97 && text.charAt(textIndex) <= 122) { // small letters
                    encrypted = encrypted + (char) (((text.charAt(textIndex) - 97 + key.charAt(i) - 96) % 26) + 97);
                    // use modulus here to make it go back to the beginning
                    // if it exceedes the letter Z
                } else if (text.charAt(textIndex) >= 65 && text.charAt(textIndex) <= 90) { // capital letters
                    encrypted = encrypted + (char) (((text.charAt(textIndex) - 65 + key.charAt(i) - 64) % 26) + 65);
                }
                textIndex++;
            }
        }
        return encrypted;
    }
    
    /*
     * decrypts an vigenere cipher text "text" using the key "key"
     */
    public static String decrypt(String text, String key) {
        String encrypted = "";
        int textIndex = 0;

        while (textIndex < text.length()) {
            for (int i = 0; (i < key.length()) && (textIndex < text.length()); i++) {
                if (text.charAt(textIndex) >= 97 && text.charAt(textIndex) <= 122) { // small letters
                    char temp = (char) ((int) text.charAt(textIndex) - (int) (key.charAt(i) - 96));
                    if (temp < 97) {
                        temp = (char) (temp + 26);
                    }
                    encrypted = encrypted + temp;
                    // use modulus here to make it go back to the beginning
                    // if it exceedes the letter Z
                } else if (text.charAt(textIndex) >= 65 && text.charAt(textIndex) <= 90) { // capital letters
                    char temp = (char) ((int) text.charAt(textIndex) - (int) (key.charAt(i) - 64));
                    if (temp < 65) {
                        temp = (char) (temp + 26);
                    }
                    encrypted = encrypted + temp;
                }
                textIndex++;
            }
        }
        return encrypted;
    }

    /*
     * shifts(moves) the letters "steps" step to the right
     * eg. shiftLetters("abcd", 1) returns "dabc"
     */
    public static String shiftLetters(String text, int steps) {
        String temp = "";
        for (int i = text.length() - steps; i < text.length(); i++) {
            temp = temp + text.charAt(i);
        }
        for (int i = 0; i < text.length() - steps; i++) {
            temp = temp + text.charAt(i);
        }
        return temp;
    }
    
    /*
     * determines the key length on krypto trying the length from "from" to "to"(not inclusive "to")
     */
    public static int determinateKeyLength(String krypto, int from, int to) {
        int guess = from;
        double smallestSquaredDiff = 100.0; // this is how close the indexOfCoincidence is to the wanted value

        while (from < to) {
            double coincidence = indexOfCoincidence(krypto, shiftLetters(krypto, from));
            
            if ((Math.pow(0.067 - coincidence, 2)) < smallestSquaredDiff) { // 0.067 = english letter of coincidence
                guess = from;
                smallestSquaredDiff = Math.pow(0.067 - coincidence, 2);
            }
            
            /* System.out.println("coincidence = " + coincidence + " wanted-coincidence ^ 2 = " + Math.pow(0.067 - coincidence, 2));
            System.out.println("best so far: " + smallestSquaredDiff + " at " + guess);/**/
            from++;
        }

        return guess;
    }
    
    /*
     * splits the string so that every "keyLength" character goes together
     * eg. partitionString("abcdef", 2) --> ace, bdf
     */
    public static String[] partitionString(String text, int keyLength) {
        String[] splited = new String[keyLength];
        for (int i = 0; i < keyLength; i++) {
            splited[i] = "";
        }
        int textIndex = 0;
        while (textIndex < text.length()) {
            for (int i = 0; i < keyLength && textIndex < text.length(); i++) {
                splited[i] = splited[i] + text.charAt(textIndex);
                textIndex++;
            }
        }
        return splited;
    }
    
    
    /*
     * steps to crack the vigenere cipher:
     * 1. determine key length
     * 2. partition the text so that each character encrypted by the same part of the keyword is together
     * 3. try different encryption characters on the partitioned characters so that the decrypted characters match
     * the normal languages index of coincidence, maybe one could try to get the total value(of the characters index of coincidence)
     * to become as high as possible
     * 
     * the from and to parameters is the intervall in which one wants to try the key(length)
     */
    public static String crackVigenere(String textToCrack, int from, int to){
        String deciphered = "";
        String[] partitioned;
        String[] ceasared;
        
        int keyLength = 0;
        keyLength = determinateKeyLength(textToCrack, from, to);
        partitioned = partitionString(textToCrack, keyLength);
        ceasared = new String[keyLength];
        
        ceasarShiftMostLikely(ceasared, partitioned);
        
        int i = 0;
        while(true){
            for(int j = 0; j < ceasared.length; j++){
                if(ceasared[j].length() > i){
                    deciphered = deciphered + ceasared[j].charAt(i);
                }
            }
            i++;
            if(i >= textToCrack.length()){
                break;
            }
        }
        
        
        return deciphered;
    }
    
    private static String[] ceasarShiftMostLikely(String[] ceasared, String[] partitioned){
        
        String keyWord = "";
        for(int i = 0; i < partitioned.length; i++){
            ceasared[i] = partitioned[i];
            double currentMax = 0;
            int currentShift = 0;
            for(int j = 0; j < 26; j++){
                if(Vigenere.sumIOC(Vigenere.ceasarShiftN(partitioned[i], j)) > currentMax){
                    currentMax = Vigenere.sumIOC(Vigenere.ceasarShiftN(partitioned[i], j));
                    ceasared[i] = Vigenere.ceasarShiftN(partitioned[i], j);
                    currentShift = j;
                }
            }
            keyWord = keyWord + (char)((int)'A' + (25-currentShift));
        }
        
        return ceasared;
    }
    
    private static double sumIOC(String text){
        double sum = 0;
        
        for(int i = 0; i < text.length(); i++){
            sum += FrequencyTable.getEnglishFrequency(text.charAt(i)-65); // dont hardcode 65 here as all letter might not be capital
        }
        
        return sum;
    }
    
    
    /*
     * calculates how many letters match at the same place in the two texts and returns the percentage that does match
     */
    public static double indexOfCoincidence(String original, String shifted) {
        int coincidences = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == shifted.charAt(i)) {
                coincidences++;
            }
        }
        return (double) coincidences / (double) original.length();
    }

    /*
     * shift all the letters in the text to an n character later letter eg.
     * ceaserShiftN("abc", 1) --> bcd ceaserShiftN("XYZ", 3) --> ABC
     */
    public static String ceasarShiftN(String text, int n) {
        String shifted = "";
        int textIndex = 0;
        while (textIndex < text.length()) {
            if (text.charAt(textIndex) >= 97 && text.charAt(textIndex) <= 122) {
                shifted = shifted + (char)((((text.charAt(textIndex)-97) + n)%26)+97);
            } else if (text.charAt(textIndex) >= 65 && text.charAt(textIndex) <= 90) {
                shifted = shifted + (char)((((text.charAt(textIndex)-65) + n)%26)+65);
            }
            textIndex++;
        }

        return shifted;
    }

    /*
     * returns an string that is a copy of the original text but with all the
     * special characters removed such as space and stuff
     */
    public static String removeSpecialChars(String text) {
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) >= 65 && text.charAt(i) <= 90) || (text.charAt(i) >= 97 && text.charAt(i) <= 122)) {
                temp = temp + text.charAt(i);
            }
        }
        return temp;
    }
}
