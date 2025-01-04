#Write a recursive function to calculate the sum of numbers from 0 to 10

def count_sum_numbers(n):
    if n:
        return n+count_sum_numbers(n-1)
    else:
        return 0
result = count_sum_numbers(10)
print(result)