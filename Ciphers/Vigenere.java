package Ciphers;
import java.util.HashMap;
import java.util.Map;

public class Vigenere{
    private String[] message;
    private Boolean cryptType;
    private String key;
    private Map<Character, Integer> keyValues;

    public Vigenere(String message, Boolean cryptType, String key){
        this.message = message.toUpperCase().split(" ");
        this.cryptType = cryptType;
        this.key = key.toUpperCase();
        this.keyValues = new HashMap<>();

        keyValues.put('A', 0);
        keyValues.put('B', 1);
        keyValues.put('C', 2);
        keyValues.put('D', 3);
        keyValues.put('E', 4);
        keyValues.put('F', 5);
        keyValues.put('G', 6);
        keyValues.put('H', 7);
        keyValues.put('I', 8);
        keyValues.put('J', 9);
        keyValues.put('K', 10);
        keyValues.put('L', 11);
        keyValues.put('M', 12);
        keyValues.put('N', 13);
        keyValues.put('O', 14);
        keyValues.put('P', 15);
        keyValues.put('Q', 16);
        keyValues.put('R', 17);
        keyValues.put('S', 18);
        keyValues.put('T', 19);
        keyValues.put('U', 20);
        keyValues.put('V', 21);
        keyValues.put('W', 22);
        keyValues.put('X', 23);
        keyValues.put('Y', 24);
        keyValues.put('Z', 25);

    }

    public String encrypt(){
        String cipherText = "";
        int index = 0;
        for (int i = 0; i < message.length; i++){
            for (int j = 0; j < message[i].length(); j++){
                char currentCharacter = message[i].charAt(j);
                if (Character.isLetter(currentCharacter)){
                    char base = 'A';
                    currentCharacter = (char) ((currentCharacter - base + keyValues.get(key.charAt(index)))%26 + base);
                    cipherText += currentCharacter;
                    index = (index+1) % key.length();
                }
            }
            cipherText += " ";
        }
        return cipherText;
    }

    public String decrypt(){
        String plainText = "";
        int index = 0;
        for (int i = 0; i < message.length; i++){
            for (int j = 0; j < message[i].length(); j++){
                char currentCharacter = message[i].charAt(j);
                if (Character.isLetter(currentCharacter)){
                    char base = 'A';
                    currentCharacter = (char) ((currentCharacter - base + (26-keyValues.get(key.charAt(index))))%26 + base);
                    plainText += currentCharacter;
                    index = (index+1) % key.length();
                }
            }
            plainText+= " ";
        }
        return plainText;
    }

    public String toString(){
        String string = "";
        if (cryptType){
            string = "The encryption of the message is:\n" + encrypt();
        }
        else{
            string = "The decryption of the message is:\n" + decrypt();
        }
        return string;
    }
}