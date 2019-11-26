def find_longest_word(words:list):
    longest_words:str = words[0]
    for word in words:
        if len(word) > len(longest_words):
            longest_words = word
        return longest_words

    print(find_longest_word(['Ali','Monas','Tambel ban'])