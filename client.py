import os,socket
s = socket.gethostname()
host = "localhost"
port = 12397
s.connect((host,port))
f = open('send.txt','rb')
l = f.read(1024)
while(l):
	s.send(l)
	l = f.read(1024)
s.shutdown(socket.SHUT_WR)
f.close()
