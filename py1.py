import os
import sys
import types
import stat

name = raw_input("Enter the file name: ")

fd = os.open(name, os.O_RDWR | os.O_CREAT)
sta = os.fstat(fd)

print "Inode no. is %d"%sta.st_ino
print "Group id is %d"%sta.st_gid
print "User id is %d"%sta.st_uid
print "Size : %d"%sta.st_size
print "Block Size : %d"%sta.st_blksize

print "File Permissions: "

st = os.stat(name)
q = st.st_mode
oct(q)
os.close(fd)
