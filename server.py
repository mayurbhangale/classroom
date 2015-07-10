import os,socket

s = socket.gethostname()
host = '127.0.0.1'
port = 12397
s.bind((host,port))
f = open('rec.txt','wb')
s.listen(10)
while True:
	c,addr = s.accept()
	print "The connected system is  : ",addr
	l = c.recv(1024)
	while(l):
		f.write(l)
		l = c.recv(1024)
	f.close()
	c.close()
