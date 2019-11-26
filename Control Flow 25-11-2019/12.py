def pig_latin(text:str):
    # if len(text) >= 2:
    #     first_char = text[0:1]
    #     return text[1:len(text)] + text[0:1] + "ay"
    # else:
    #     return "Error"
    return text[1:len(text)] + text [0:1] + "ay" if len(text) >= 2 else "Error"

print(pig_latin('abc'))