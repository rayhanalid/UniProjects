def is_vowel(character:str):
    list_of_vowel:list = ['a','i','u','e','o']
    for i in range(len(list_of_vowel)):
        if list_of_vowel[i].upper() == character.upper():
            return True
    return False

print(is_vowel('a'))