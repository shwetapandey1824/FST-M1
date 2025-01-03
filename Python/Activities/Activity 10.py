'''Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5'''
user_tuple = tuple(input("Enter the numbers separted with commas:").split(","))

count=0
#logic to check tuple numbers are divisible or not
print("Numbers which is divisible in given tuples are: ")
for i in range(0,len(user_tuple)):
    if (int(user_tuple[i]) % 5 ==0):
        print(user_tuple[i])
        count=count+1

#If tuple not having any number divisible by 5
if count==0:
    print("Tuples is not hvaing any number is divisible by 5")