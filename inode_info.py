import os
import sys
import types
import stat
import subprocess

name = raw_input("Enter File Name : ")
fd = os.open(name,os.O_RDWR | os.O_CREAT)
sta = os.fstat(fd)

print "INODE no. is %d " %sta.st_ino
print "Group ID is %d " %sta.st_gid
print "User ID is %d " %sta.st_uid
print "File size is %d " %sta.st_size
print "Block size is %d " %sta.st_blksize

print "File Permissions: "

subprocess.call(["ls", "-l", name])
os.system("ls -l" name)
os.close(fd)
