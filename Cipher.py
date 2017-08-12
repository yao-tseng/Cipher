def EncryptCipher():
    print ("Running Encryption.....")
    string = input("Enter plaintext: ")
    while len(string) == 0:
        string = input("Enter plaintext: ") #Do you even need this program?
    key = input("Enter key: ")
    while len(key) == 0:
        key = input("Enter key: ") #Quit being a dumbass
    print("Plaintext: " + string)
    i = 0
    key = key.lower()
    ciphertext = ""
    for letter in string:
        if letter.isalpha() and letter.isupper():
            ciphertext = ciphertext + chr(((ord(letter)+ord(key[i%len(key)])-97+13)%26)+65)
            i = i+1
        elif letter.isalpha() and letter.islower():
            ciphertext = ciphertext + chr(((ord(letter)+ord(key[i%len(key)])-97+7)%26)+97)
            i = i+1
        else:
            ciphertext = ciphertext + string[i]
            i = i+1
    print ("Ciphertext: " + ciphertext)
    

def DecryptCipher():
    print ("Running Decryption.....")
    string = input("Enter ciphertext: ")
    while len(string) == 0:
        string = input("Enter ciphertext: ")
    key = input("Enter key: ")
    while len(key) == 0:
        key = input("Enter key: ")
    print("Ciphertext: " + string)
    i = 0
    key = key.lower()
    plaintext = ""
    for letter in string:
        if letter.isalpha() and letter.isupper():
            plaintext = plaintext + chr(((ord(letter)-(ord(key[i%len(key)])-97)+13)%26)+65)
            i = i+1
        elif letter.isalpha() and letter.islower():
            plaintext = plaintext + chr(((ord(letter)-(ord(key[i%len(key)])-97)+7)%26)+97)
            i = i+1
        else:
            plaintext = plaintext + string[i]
            i = i+1
    print ("Plaintext: " + plaintext)
    
    
EncryptCipher()
DecryptCipher()