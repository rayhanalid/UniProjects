from random import randint

class Name:
    User = input('Enter Your Name : ')
    user_player = User
    Comp = input('Enter the Name NPC : ')
    comp_npc = Comp

    def __str__(self):
        return pemain

options = ["Rock", "Paper", "Scissors", "Lizard", "Spock"]
player = False
score = 0
score_1 = 0
games_played = 0
NPC = options[randint(0, 4)]

while player == False:
    if score == 5:
        print("Congratulations" + " " + Name.user_player + " You win the game!" )
        player = True
        break
    elif score_1 == 5:
        print("Too Bad"+Name.comp_npc+ " win the game!")
        player = True
        break

    player = input("Rock,Paper,Scissors,Lizard,Spock : ")

    if player == NPC:
            print("It's A Draw")
            games_played +=1
    elif player == "Rock":
            if NPC == "Paper" :
                print("You Lose!", NPC, "Covers", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Scissors":
                print("Congratulations, You Win!", player, "Smash", NPC)
                score += 1
                games_played +=1
            elif NPC == "Lizard":
                print("Congratulations, You Win!", player, "Crush", NPC)
                score += 1
                games_played +=1
            else:
                print("You Lose!", NPC, "Vaporize", player)
                score_1 += 1
                games_played +=1
    elif player == "Paper":
            if NPC == "Rock":
                print("Congratulations, You Win!", player, "Covers", NPC)
                score += 1
                games_played +=1
            elif NPC == "Scissors":
                print("You Lose!", NPC, "Cut", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Lizard":
                print("You Lose!", NPC, "Eats", player)
                score += 1
                games_played +=1
            else:
                print("Congratulations, You Win!", player, "Disaproves", NPC)
                score += 1
                games_played +=1
    elif player == "Scissors":
            if NPC == "Rock":
                print("You Lose!", NPC, "Smash", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Paper":
                print("Congratulations, You Win!", player, "Cut", NPC)
                score += 1
                games_played +=1
            elif NPC == "Lizard":
                print("Congratulations, You Win!", player, "Decapitates", NPC)
                score += 1
                games_played +=1
            else:
                print("You Lose!", NPC, "Smashes", player)
                score_1 += 1
                games_played +=1

    elif player == "Lizard":
            if NPC == "Rock":
                print("You Lose!", NPC, "Crushes", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Scissors":
                print("You Lose!", NPC, "Decapitates", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Spock":
                print("Congratulations, You Win!", player, "Poisons", NPC)
                score += 1
                games_played +=1
            else:
                print("Congratulations, You Win!", player, "Eats", NPC)
                score += 1
                games_played +=1
    elif player == "Spock":
            if NPC == "Rock":
                print("Congratulations, You Win!", player, "Vaporize", NPC)
                score += 1
                games_played +=1
            elif NPC == "Paper":
                print("You Lose!", NPC, "Disaproves", player)
                score_1 += 1
                games_played +=1
            elif NPC == "Scissors":
                print("Congratulations, You Win!", player, "Smashes", NPC)
                score += 1
                games_played +=1
            else:
                print("You Lose!", NPC, "Poisons", player)
                score_1 += 1
                games_played +=1
    else:
        print("I Can't Understand The Word, Check Your Spelling")
    player = False
    print("Total Games Played :")
    print(games_played)
    print("Your Score is :")
    print(score)
    print("NPC Score is :")
    print(score_1)
    NPC = options[randint(0, 4)]
