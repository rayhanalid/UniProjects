Fridge_items: {str: int} = {}

open_Fridge = True

def put_items(put_fish, number_of_fish):
    if put_fish in Fridge_items:
        Fridge_items[put_fish] += number_of_fish
    else:
        Fridge_items[put_fish] = number_of_fish

def take_items(take_fish, left_items):

    if question1_2_1 > Fridge_items[question1_2]:

        print("There is not enough " + question1_2 + " to take out.")

        print("You only have: " + Fridge_items[question1_2])

    elif question1_2_1 <= Fridge_items[question1_2]:

        print("Enjoy the " + question1_2)

    elif take_fish in Fridge_items:

        Fridge_items[take_fish] -= left_items

    else:

        print("There is no", take_fish, "in fridge !")

def view_items():

    if Fridge_items.items() != 0:

        for i in Fridge_items.items():

            print(i)

            print("-----------------------")





while True:

    while open_Fridge:



        print("\nFridge")

        user = input("Enter Your Name : ")

        print("Hey,",user.title(),"!")

        question = input("Would you like to open the Fridge? Yes = 1 /No = 0 : ")

        if question.lower() == "1":

            print("Alright",user.title(),"!")

            question1 = input("Choose an action: Put/Take/View : ")

            if question1.lower() == "put":

                question1_1 = input("What kind of fish would you like to put? : ")

                question1_1_1 = input("How many " + question1_1 + " would you like to put? : ")

                put_items(question1_1, question1_1_1)

                print(question1_1, "is now in the Fridge.")


            elif question1.lower() == "take":

                question1_2 = input("What Fish would you like to take out? : ")

                question1_2_1 = input("How many " + question1_2 + " would you like to take out? : ")

                take_items(question1_2, question1_2_1)

                print("Don't forget to Stay Healthy")

            elif question1.lower() == "view":



                print(view_items())


            else:

                print("Your input is invalid")

        elif question.lower() == "0":

            print("Okay, See You Later!", user.title())

        else:

            print("Your input is invalid.")