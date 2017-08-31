Welcome to the cipher repository. Please read below for descriptions on each cipher (alphabetically)

____________________

Atbash Cipher

Type: Substitution
Difficulty: Easy

Description:

Atbash is a type of cipher that takes the alphabet and maps it to its 
reverse. The first letter becomes the last letter and the second letter 
becomes the second to last letter and so on.

This is a particularly easy cipher in that it does not require a key.

Method:

a b c d e f g h i j k l m n o p q r s t u v w x y z

becomes

z y x w v u t s r q p o n m l k j i h g f e d c b a

____________________

Autokey Cipher

Type: Key
Difficulty: Moderate

Description:

The two types of autokey are key and text. Key takes the key and appends the plaintext message repeating to the end as the key for ciphertext. Text uses the previous message to generate a key to use for the next key + plaintext combination.

The plaintext is then shifted the number of letters corresponding to the letter at that location in the key. A is one shift, B is two shift, and so on.

Example:

Plaintext: Attack at dawn
Keyword: Queenly
Key: Queenl ya ttack at dawn
Ciphertext: Qnxepv yt wtwp

____________________

Beaufort Cipher

Type: Substitution
Difficulty:

Description:

The Beaufort cipher is a variant of the Vigenere cipher. Where the Vignenere uses the key to offset the plaintext to the right, producing the ciphertext, Beaufort uses the key to find the integer value of the offset from plaintext to key (0-25) and converts that to the ciphertext letter. Key repeats if the length is shorter than the plaintext.

Example:

Plaintext: chocolate cake
Key: key

From c to k (1st letters), the offset is 8 the integer value of letter i.
From h to e (2nd letters), the offset is 23 the integer value of letter x

Ciphertext: ixkiqnkluieog

____________________
