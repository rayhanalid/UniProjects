def reverse(text:str):
    # reversed_text:str = ""
    # for i in range(len(text)-1,-1,-1):
    #     reversed_text += text[i]
    return text[::-1]

print(reverse("hello world"))

# re = lambda text:text[::-1]
# print(re('hellp'))