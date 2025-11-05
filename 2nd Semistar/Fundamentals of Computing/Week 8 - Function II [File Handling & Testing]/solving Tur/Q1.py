def read_sales_data(file_path):
    a = []
    file = open(file_path, 'r')
    for line in file:
        line = line.strip()
        line = line.split(',')
        a.append(line)
    file.close()
    return a

def write_sales_report(output_path, processed_data):
    file = open(output_path, 'w')
    for i in range(len(processed_data)):
        # Make sure there are at least 3 items in each row
        if len(processed_data[i]) >= 3:
            file.write('Product Name: ')
            file.write(processed_data[i][0] + '\n')

            file.write('Unit Sold: ')
            file.write(processed_data[i][1] + '\n')

            file.write('Price per unit: ')
            file.write(processed_data[i][2] + '\n')

            file.write('\n')
        else:
            file.write('Invalid record: ' + str(processed_data[i]) + '\n\n')
    file.close()


A = read_sales_data('stock.txt')
write_sales_report('report.txt', A)
