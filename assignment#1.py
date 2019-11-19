guest_list = ["Mod" , "Jennifer" , "Albert Einstood" , "Spongebob Squarepants"]

del guest_list[0]
guest_list.append("Bond")
print("I Just Rent A Bigger Table")


guest_list.insert(0, "Potter")
guest_list.insert(3, "Lovegood")
guest_list.append("D-Bag")
for i in range (7):
    print("Hey, " + guest_list[i] + " You're Invited to My Dinner")
print("My Table Would not Arrive In Time")   
while len(guest_list) !=2:
    guest_popped = guest_list.pop()
    print(guest_popped + " Sorry But My Dinner Is Cancelled Because i can only invite 2 people")
for i in range(2):
    print(guest_list[i] +  " Hey, You still get Invited to My Dinner Party" )

del guest_list[0:2]
print(guest_list)

locations = ["Iceland" , "Greenland" , "England" , "Australia" , "Indonesia"]
print(locations)
print(sorted(locations))
print(sorted(locations))
locations.reverse()
print(locations)
locations.sort()
print(locations)
locations.sort(reverse=True)
print(locations)

#Part 2 No 1
degrees_number = 8
radians_number = degrees_number * (180/(3/14))
print("Degrees;" + str(degrees_number))
print("Radians;" + str(radians_number))

#No 2
student1 = 80.0
student2 = 90.0
student3 = 66.5
average_score = (student1 + student2 + student3) / 3
print("studentscores:")
print(student1)
print(student2)
print(student3)
print(average_score)

#No 3
class1 = 32
class2 = 45
class3 = 51
class1_groups = 32//5
class2_groups = 45//7
class3_groups = 51//6
leftovers1 = (class1-(class1_groups)*5)
leftovers2 = (class2-(class2_groups)*7)
leftovers3 = (class3-(class3_groups)*6)
print("Class1" + str(class1_groups))
print("Class2" + str(class2_groups))
print("Class3" + str(class3_groups))
print("Number of Leftovers:")
print("class1:" + str(leftovers1))
print("class2:" + str(leftovers2))
print("class3:" + str(leftovers3))

#No 4
pi = 3.14 
pie_diameter = 55.4 
pie_radius = pie_diameter / 2 
circumference = 2 * pi * pie_radius 
circumference_msg = "Jimmy’s pie has a circumference: "
print(circumference_msg, circumference) 

#No 5

meters = 20580
speed = meters / 60
frequency = 256
wavelength = speed / frequency
print("The Speed (m/s)" + str(speed))
print("The Frequency (Hz)" + str(frequency))
print("The Wavelength (m)"  + str(wavelength)) 
