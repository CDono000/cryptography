package Ciphers;

public class Caesar{
    private String message;
    private String cryptType;
    private int key;

    public Caesar(String message, String cryptType, int key){
        this.message = message;
        this.cryptType = cryptType;
        if (cryptType == "d"){
            this.key = 26-key;
        } else{
            this.key = key;
        }
    }

    public String createNewMessage(){
        String answer = "";
        for (int i = 0; i < message.length(); i++){
                char currentCharacter = message.charAt(i);
                if (Character.isLetter(currentCharacter)){
                    char base = Character.isLowerCase(currentCharacter) ? 'a' : 'A';
                    currentCharacter = (char) ((currentCharacter - base + key) % 26 + base);
                }
                answer += currentCharacter;
            }
            return answer;
    }

    public String toString(){
        if (key == 0 || key == 26){
            if (cryptType == "e"){
                return "Invalid data entered: Can not Encrypt with an empty Key";
            }
            String answer = "Possible Answers:\n";
            for (var i = 1; i < 26; i++){
                key = i;
                answer += createNewMessage() + "\n";
            }
            return answer;
        }
        else{
            String meaning = (cryptType == "e") ? "encryption" : "decryption";
            return "The " + meaning + " of the message is:\n" + createNewMessage();
        }
    }
}