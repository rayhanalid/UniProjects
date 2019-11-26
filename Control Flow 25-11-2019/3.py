def get_length(elements):
    length:int = 0
    for e in elements:
        length+=1
    return length

print(get_length([1,1,2]))
print(get_length("hello"))
