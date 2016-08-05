#for the energy solution in a cell free reaction 
#"Remaining" was originally part of the csv file when imported

#import csv file with reagents
import csv 
import pandas
f = pandas.read_csv('/Users/annikagude/Desktop/copycsv.csv')
#Find the amount left after 1 experiment
f['new_remaining'] = f['Total']+f['Used']
print (f)

fileReader = open('csvpro.csv')
csv_f = csv.reader(fileReader)
row_count = sum(1 for row in csv_f)

#for loop to know if you have enough for 1 reaction
print("\nReagent Required for 1 Reaction?")
for i in range (0,row_count-2):
    print (f.iloc [i]['new_remaining'] >= 0)


#loop to know which reagents to order more of and amount

print("\n\nDo I need to order more reagent?")
for j in range(0,row_count -2):
    if(f.iloc [j]['new_remaining'] < 0):
        print("Order More " + f.iloc [j]['Name'])


#Reaction done "3" times 
def energysol(argv1):
    (f['Used'] * argv1 + f['Total'])
    f['afterEnergySol'] = (f['Used'] * argv1) + f['Total']
    return;

print("\n\nChecking Reagent using a function:")
energysol(3)
    
#f['three_reactions']= energysol
print(f)    

print ("\n\n")
type(f)

#Imported the csv file as a list 

import csv

f = open('csvpro.csv')

csv_f = csv.reader(f)

for row in csv_f:
	print (row)

import pandas
f = pandas.read_csv('/Users/annikagude/Desktop/copycsv.csv')
import numpy

print ("\n\n How many reactions can be performed?")
#how many reactions can be performed with the total amount of reagent
f['Total_Reactions'] =(f['Total'] / f['Used'])* (-1)
#integer amount
f['rounded_down'] = numpy.floor(f['Total_Reactions'])

#How much reagent is remaining after all the reactions are performed
f['Remaining_Reagent']=(f['Total'] % f['Used'])* (-1) 
print (f)
