Welcome to the cipher repository. Please read below for descriptions on each cipher (alphabetically)

____________________

**Atbash Cipher**

Type: Substitution
Difficulty: Easy

*Description:*

Atbash is a type of cipher that takes the alphabet and maps it to its 
reverse. The first letter becomes the last letter and the second letter 
becomes the second to last letter and so on.

This is a particularly easy cipher in that it does not require a key.

*Method:*

a b c d e f g h i j k l m n o p q r s t u v w x y z

becomes

z y x w v u t s r q p o n m l k j i h g f e d c b a

____________________

**Autokey Cipher**

Type: Key
Difficulty: Moderate

*Description:*

The two types of autokey are key and text. Key takes the key and appends the plaintext message repeating to the end as the key for ciphertext. Text uses the previous message to generate a key to use for the next key + plaintext combination.

The plaintext is then shifted the number of letters corresponding to the letter at that location in the key. A is one shift, B is two shift, and so on.

*Example:*

Plaintext: Attack at dawn
Keyword: Queenly
Key: Queenl ya ttack at dawn
Ciphertext: Qnxepv yt wtwp

____________________

**Beaufort Cipher**

Type: Key, Substitution
Difficulty:

*Description:*

The Beaufort cipher is a variant of the Vigenere cipher. Where the Vignenere uses the key to offset the plaintext to the right, producing the ciphertext, Beaufort uses the key to find the integer value of the offset from plaintext to key (0-25) and converts that to the ciphertext letter. Key repeats if the length is shorter than the plaintext.

*Example:*

Plaintext: chocolate cake
Key: key

From c to k (1st letters), the offset is 8 the integer value of letter i.
From h to e (2nd letters), the offset is 23 the integer value of letter x

Ciphertext: ixkiqnkluieog

____________________

**Caesar Cipher**

Type: Substitution
Difficulty: Easy

*Description:*

This cipher is an easy one to break. Caesar cipher take the plaintext and shifts it an integer amount to the left to create the ciphertext.

*Method:*

Plaintext:
What would a wood chuck do?

Shift:
3

Ciphertext:
zkdwzrxogdzrrgfkxfngr

____________________

**Columnar Trans Cipher**

Type: Key
Difficulty: Hard

*Description:*

Columnar Trans takes the length of the key to create that many columns. Then it takes the plaintext and inserts each letter into columns left to right wrapping back to the first column each time. In alphabetical order of the letters in the key, it takes the column of that letter from top to bottom and adds it to the ciphertext.

*Example:*

Plaintext:
Life was like a box of chocolates.

Key:
cipher

Process:

C|I|P|H|E|R
-|-|-|-|-|-
1|4|5|3|2|6
l|i|f|e|w|a
s|l|i|k|e|a
b|o|x|o|f|c
h|o|c|o|l|a
t|e|s

C(lsbht) E(wefl) H(ekoo) I(ilooe) P(fixcs) R(aaca)

Ciphertext:
lsbhtweflekooilooefixcsaaca

____________________

**Pig Latin**

Type: Translation
Difficulty: Moderate

*Description:*

Pig Latin alters words in the English language using a simple set of rules. It takes the first consonant or consonant cluster and moves it to the end while adding 'ay' to it. If the word begins with a vowel then only 'way' is added to the end.

*Example:*

Plaintext: 
How are you today?

Pig Latin: 
Owhay areway ouyay odaytay?

____________________

**Rail Fence Cipher**

Type: Transposition
Difficulty: Hard

*Description:*

Rail Fence takes an input string and the number of rails to transpose the text across. The input string is transposed diagonally across the rails until it reaches the last rail and then reverses direction diagonally back up to the first rail. The cipher code is then taken from the rails starting with the first rail and placing the letters in sequence.

*Example:*

Plaintext: Never Gonna Give You Up
Number of rails: 4

n-----o-----v-----p  
-e---g-n---i-e---u-  
--v-r---n-g---y-u--  
---e-----a-----o---  

Ciphertext: novpegnieuvrngyueao

____________________

**ROT 13 Cipher**

Type: Substitution
Difficulty: Easy

*Description:*

Rot 13 is a simple substitution cipher that replaces the letter in the plaintext with the letter 13 places after it. Since there are 26 letters in the alphabet, this cipher is its own inverse. Putting in the cipher text in the same code for encryption will also decrypt the text.

*Example:*

Plaintext: Sweet dreams are made of these

s|w|e|e|t|d|r|e|a|m|s|a|r|e|m|a|d|e|o|f|t|h|e|s|e
-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-
f|j|r|r|g|q|e|r|n|z|f|n|e|r|z|n|q|r|b|s|g|u|r|f|r

Ciphertext: fjrrgqernzfnerznqrbsgurfr

____________________

**Vigenere Cipher**

Type: Key, Substitution
Difficulty: Medium

*Description:*

The Vigenere Cipher uses a key to offset the input text a number of spaces to the right based on the integer value of the letter in the key at the same location as the input text. If the key is too short then the key repeats itself.

*Example:*

Plaintext: That's All Folks!
Key: key

t is offset to the right k(11) letters resulting in e  
h is offset to the right e(5) letters resulting in m

Ciphertext: emzexzwqezqjd
