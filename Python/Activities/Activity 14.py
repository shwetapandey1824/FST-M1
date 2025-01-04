'''Using Recursion:

Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.'''


def fibonnaci_series(num):
    if num<=1:
        return num
    else:
        return fibonnaci_series(num-1)+fibonnaci_series(num-2)

#Take user inputs how many Fibonnaci numbers to generate
num_input = int(input("Please Enter the numbers you want to get fibonnaci series: "))

#calls fibonnai series function as per user input
if num_input<=0:
    print("Please enter the positive values: ")
else:
    print("Here is your FIbonnaci series: ")
    for i in range(num_input):
        print(fibonnaci_series(i),end=" ")
