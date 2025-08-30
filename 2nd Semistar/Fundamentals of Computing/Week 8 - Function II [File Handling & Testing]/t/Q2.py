with open ('lab8.txt', 'r') as f:
    for line in f.readlines():
        line = line.split(",")
        print(line)
