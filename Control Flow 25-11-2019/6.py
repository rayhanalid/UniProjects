def is_palindrome(text:str):
    return text[::-1].upper() == text.upper()

print(is_palindrome('radar'))
