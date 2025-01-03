#Write a Python program to calculate the sum of all the elements in a list.

numbers = list(input("Enter the numbers using comma: ").split(","))

sum = 0

for i in numbers:
    sum=sum+int(i)

print(sum)