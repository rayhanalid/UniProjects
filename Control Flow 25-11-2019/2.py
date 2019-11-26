def max_of_three(num_a:int,num_b:int,num_c:int):
    return num_a if num_a > num_b and num_a > num_c else num_b if num_b > num_a and num_b > num_c else num_c

print(max_of_three(10,20,30))