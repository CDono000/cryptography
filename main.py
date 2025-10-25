import subprocess
import os

def cls():
    os.system('cls' if os.name=='nt' else 'clear')

cipherType = " "
ciphers = []
current = 0
while cipherType != "":
    while cipherType == " " or cipherType == "n":
        print("Enter the number of the cipher you would like to use")
        print("Press enter to exit or n for next\n")
        for i in range((current*10), ((current+1)*10)):
            try:
                print((i+1) + ": " + ciphers[i])
            except:
                break
        cipherType = input("What cipher would you like to use? ").lower()
    if cipherType == "":
        break
    text = input("Enter the text to use: ")
    cryptType = input("Enter E for encrypt and D for decrypt: ").lower()
    key = input("Enter the key to use (If key is unknown enter 0): ")
    result = subprocess.run(["java", "ciphers/"+ciphers[int(cipherType)-1], text, cryptType, key], capture_output=True, text=True)
    print(result.stdout)

# Print the output from the Java code
