'''Create a Python dictionary that contains a bunch of fruits and their prices.

Write a program that checks if a certain fruit is available or not.'''

fruits_shop = {
    "apple":"50",
    "orange":"60",
    "litchi":"20"
}

user_input = input("What fruit are you looking today:").lower()

if user_input in fruits_shop:
    print("Yay!! {0} is available in stock.".format(user_input))
else:
    print("OOps!!Its not available.Please visit again")