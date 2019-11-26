def translate(text:str):
    vowel:list = ['a','i','u','e','o',' ']
    final_text:str = ""
    for char in text:
        if not vowel._contains_(char):
            final_text+=char+'o'+char
        else:
            final_text+=char
        return final_text

print(translate('this is fun'))
