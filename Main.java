import Ciphers.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String [] ciphers = {"Caesar", "Vigenere"};
        int current = 0;
        String decision = "n";
        java.util.Scanner inputs = new Scanner(System.in);

        while (decision == "n"){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter the number of the cipher you want to use\nEnter 'n' for next page\n ");
            for (int i = (current * 10); i < Math.min(ciphers.length, (current + 1) * 10); i++){
                System.out.println((i+1) + ": " + ciphers[i]);
            }
            decision = inputs.nextLine();
        }
        System.out.println("What is your message");
        String message = inputs.nextLine();
        System.out.println("Enter E for encrption and D for decryption");
        Boolean encrypt = inputs.nextLine().trim().toLowerCase().equals("e");
        System.out.println("Enter the key");
        String key = inputs.nextLine();
        //Temporary code
        //Ask lecturers about dynamic attribution of data types
        if (Integer.parseInt(decision)-1 == 0){
            System.out.println(new Caesar(message, encrypt, Integer.parseInt(key)));
        }
        if (Integer.parseInt(decision)-1 == 1){
            System.out.println(new Vigenere(message.toUpperCase(), encrypt, key.toUpperCase()));
        }
    }
}