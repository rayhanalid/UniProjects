def filter_long_words(words:list,length:int):
    list_of_words:list = []
    for word in words:
        if len(word) > length:
            list_of_words.append(word)
    return list_of_words

print(filter_long_words(['saya','agagaaa','gagagagagagagaag'],5))
