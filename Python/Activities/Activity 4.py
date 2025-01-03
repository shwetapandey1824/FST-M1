# --------------Rock Paper scissors game----------------
'''Rules are  2 players and Rock,scissors,paper
Rock beats scissors
Scissors beats paper
Paper beats rock
'''

#get users name
player1 = input("Please Enter Player1 Name:")
player2 = input("Please Enter Player2 Name:")

#Welcome Message
print("Hello {} & {} !! Welcome in ROck Paper Scissor Game!!".format(player1,player2))

while True:
    #Get the user's choice
    p1_choice = input(player1+", Please enter your choice: Rock,paper or Scissors!!").lower()
    p2_choice = input(player2+", Please enter your choice: Rock,paper or Scissors!!").lower()

    #Logic for game-------------
    if p1_choice == p2_choice:
        print("OOPS! Its a tieeee!!!")
    elif p1_choice == "rock":
        if p2_choice == "scissors":
            print("Rock Wins!!!")
        else:
            print("Paper Wins!!!")
    elif p1_choice == "scissors":
        if p2_choice == "paper":
            print("Scissors Wins!!")
        else:
            print("Rock Wins!!")
    elif p1_choice == "paper":
        if p2_choice == "rock":
            print("Paper Wins!!")
        else:
            print("Scissors Wins!!")
    else:
        print("Invalid Choice!!Please select form ption ROck,Paper or Scissiors")

    #Ask user to play game again
    question = input("Do you want to play this game again, Yes/No??").lower()

    #If user is saying yes then do nothing
    if question == "yes":
        pass
    #If user is saying no ,exit the game
    elif question== "no":
        raise SystemExit
    #If they say anythng else show erro of invalid answer
    else:
        print("Invalid Choice , Will take as No ")
        raise SystemExit