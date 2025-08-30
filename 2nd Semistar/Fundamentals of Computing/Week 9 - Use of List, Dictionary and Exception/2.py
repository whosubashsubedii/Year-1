def updatedata (student_data):
    while True:
        id_input = input("Enter the id: ")
        if_exits = False
        for row in student_data:
            if row (0) == id_input:
                id_exits = True
                break
        if not id_exits:
            print("Enter a vaild ID: ")
        
        else:
            break
    
    for i in range (len(student_data)):
        if student_data[i] [0] == id_input:
            while True:
                Try:
                    marks = int (input("Enter the new marks: "))
                    student_data [i] [2] = marks
                    break #exit the loop when vaild input is given 
                except:
                    print("Invalid input. Please enter int value")
        
    return student_data

x=readdata('abc.txt')
y=updatedata(x)