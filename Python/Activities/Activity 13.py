'''Write a function sum() such that it can accept a list of elements and print the sum of all elements'''

def sum(numlist):
    sum=0
    for i in range(0,len(numlist)):
        sum=numlist[i]+sum

    return sum

#List of numbers
numbers = [10,2,111,90,9,25]

#call function
print("Sum of all elements are : ",sum(numbers))
