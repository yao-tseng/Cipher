def EncryptCipher():
    string = input("Enter plaintext: ")         #Raw input to be converted
    while len(string) == 0:                     #Check for input
        string = input("Enter plaintext: ")     #If none, then ask for input again
    key = input("Enter key: ")                  #Raw input unsed to convert Plaintext
    while len(key) == 0:                        #Check for input
        key = input("Enter key: ")              #If none, then ask for input again
    print("Plaintext: " + string)
    
                            #Variable creation
    i = 0                   #for index
    key = key.lower()       #create a consistent key for coding
    ciphertext = ""         #blank string for converted text
    for letter in string:
        if letter.isalpha() and letter.isupper():                                               #Check for uppercase letter conversion
            ciphertext = ciphertext + chr(((ord(letter)+ord(key[i%len(key)])-97+13)%26)+65)     #Convert letter at i location with interger value of key at remainder of i/(length of key) location
            i = i+1                                                                             #Progress index
        elif letter.isalpha() and letter.islower():                                             #Check for lowercase letter conversion
            ciphertext = ciphertext + chr(((ord(letter)+ord(key[i%len(key)])-97+7)%26)+97)      #Convert letter at i location with interger value of key at remainder of i/(length of key) location
            i = i+1                                                                             #Progress index
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
