def generate_n_chars(num:int,character:str):
    text:str = ""
    for i in range(num):
        text+=character
    return text

print(generate_n_chars(10,'x'))