import os,sys
import urllib
from subprocess import call

choice = int (input("Enter 0 to open menu"))
while choice<6:
	print "LOG MENU\n"
	print "1. Boot log\n2. Yum Log\n3. XORG Log\n4. Existing list of log files\n5. Exit Log\nSelect log file choice"

	choice = int(input("Enter the choice= \t"))

	if choice==1:
		os.system("cat /var/log/boot.log")

	elif choice==2:
		os.system("yum history")

	elif choice==3:
		os.system("cat /var/log/Xorg.0.log")

	elif choice == 4:
		os.system("ls /var/log")

	elif choice == 5:
		break
