def readdata (filename):
    student_data=[]
    with open (file_name,"r")as file 
        data = file.readlines()
        for lines in data:
            row = lines.replace('\n',)
            row[2] = int (row[2])
            student_data.append(row)
    return student_data

x = readdata('abc.txt')
