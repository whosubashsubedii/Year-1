N = int(input("Enter the number of elements you want in the list: "))
list1 = []
i = 1

while i <= N:
    ele = int(input("Enter the number: "))
    list1.append(ele)
    i = i + 1

print("The list you entered is:", list1)

# second part
add1 = 0  # For even numbers
add2 = 0  # For odd numbers

for x in range(len(list1)):
    if list1[x] % 2 == 0:
        add1 = add1 + list1[x]
    else:
        add2 = add2 + list1[x]

print("The addition of even numbers is:", add1)
print("The addition of odd numbers is:", add2)
