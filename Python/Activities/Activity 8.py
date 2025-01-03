#Given a list of numbers, return True if first and last number of a list is same.

numbers_list = list(input("Enter the numbers with comma separated: ").split(","))


if numbers_list[0] == numbers_list[-1]:
    print("True")
else:
    print("False")
print(numbers_list)

