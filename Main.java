import Ciphers.Caesar;

public class Main{
    public static void main(String[] args){
        Caesar cipher = new Caesar("Hello, World!", 'e', 3);
        System.out.println(cipher.toString()); // Outputs: Khoor, Zruog!

        Caesar decipher = new Caesar("Khoor, Zruog!", 'd', 0);
        System.out.println(decipher.toString()); // Outputs: Hello, World!
    }
}