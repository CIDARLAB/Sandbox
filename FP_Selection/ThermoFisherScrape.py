import bs4
import requests
import os


#This is me searching for any and all Spectra Data on Thermo Fisher Scientific
#Doesn't matter what it is, if it has spectral data, I want it
#It has 6 60 result pages
string = ("https://www.thermofisher.com/search/supportSearch?query=&navId=4294959584&sort=default&persona=DocSupport&resultsPerPage=60&resultPage=")

for i in range(1,7):
	#Download search page
	res = requests.get(string + str(i))
	res.raise_for_status()
	search = bs4.BeautifulSoup(res.text, "lxml")
	
	#Parse through the page, find each result group
	fpDir = search.findAll("div", class_="result group search-card spectra-card")
	
	#For each result group
	for each in fpDir:
		#Find the name of the spectra
		name = each.select("h2")[0].getText()
		name = name.replace(" ", "");
		name = name.replace("/", "-");

		#Find the link to get the data points
		linkText = each.select('p')[1]
		datapts = linkText.select('a')[0]
		txtLink = datapts.get('href')

		#Sadface it's a text file
		txtFile = requests.get(txtLink)
		txtFile.raise_for_status()

		#create filepath to save the text file
		filePath = os.path.join('/home/david/Desktop/ThermoFisher', name + '.txt')

		#Create the textfile and save its data in chunks.
		saveFile = open(filePath,'wb')
		for chunk in txtFile.iter_content(100000):
			saveFile.write(chunk)

		#close the textfile now that we're done.
		saveFile.close()

		print("Downloaded " + name)
