N = int(input("Enter number of students"))
i = 1
dis = {}
a=[]

while i <= N:
        student_name = int(input("Enter the name of Student : "))
        student_mark = int (input("Enter the mark of Student: "))
        dicti[name] = marks
        i = i + 1

for mark in dicti.values():
    a.append(student_mark)
maximum_first = a[0]
minimum_first = a[0]
total = 0
for num in a :
    if num > maximum_first:
        maximum_first = num
    if num > minimum_first:
        minimum_first=num
    total = total + num
avg = total/N
print(maximum_first)
print(minimum_first)
print(Avg)

file = open('result.txt','w')
file.write(str(maxi), str(mini))
file.write(str(minimum_first))
file.write(str(Avg))
