'''Given a two list of numbers create a new list such that new list should contain only odd numbers from the first list and even numbers from the second list.
'''

list1 = [1,2,3,4,5]
list2 = [3,4,5,6,7,8,9]
list3 = []

#Check the odd number from first list
for i in range(0,len(list1)):
    if list1[i]%2!=0:
        list3.append(list1[i])

# Check the even number from second list
for i in range(0, len(list2)):
    if list2[i] % 2 == 0:
        list3.append(list2[i])

#Print 3rd list result
print(list3)