def get_grade(score:float):
    return "error" if score > 1.0 else "A" if score >= 0.9 else "B" if score >= 0.8 else "C" if score >= 0.7 else "D" if score >= 0.6  else "F" 

print(get_grade(0.5)) 