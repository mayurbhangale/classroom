import urllib
import os, sys

choice=int(input("Enter 0 to see menu=\t"))
while choice<6:
	print "LOG MENU \n"
	print "1. Boot LOG \n"
	print "2. Yum LOG \n"
	print "3. XORG LOG \n"
	print "4. Existing List of LOG Files\n"
	print "5. EXIT LOG \n"
	print "Select Log FIle Choice"
	choice=int(input("Enter the choice=\t"))
	if choice==1:
		datasource = urllib.urlopen("/var/log/boot.log")
		i=0
		while i<10:
			i=i+1
			line = datasource.readline()
			if line == "": break
			if (line.find("") > -1) :
		        	print line,

			line="Boot LOG data!"
			print line,

	elif choice==2:
		datasource = urllib.urlopen("/var/log/Yum.log")
		i=0
		while i<10:
			i=i+1
			line = datasource.readline()
			if line == "": break
			if (line.find("") > -1) :
			        print line,

			line="Authentication LOG data!"
			print line,
	elif choice==3:
		datasource = urllib.urlopen("/var/log/Xorg.0.log")
		i=0
		while i<10:
			i=i+1
			line = datasource.readline()
			if line == "": break
			if (line.find("") > -1) :
			        print line,

			line="Kernel LOG data!"
			print line,
	elif choice == 4:
		# Open a file
		path = "/var/log"
		dirs = os.listdir( path )

		# This would print all the files and directories
		for file in dirs:
		   print file
	elif choice == 5:
		break
