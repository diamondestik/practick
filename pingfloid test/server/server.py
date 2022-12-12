import socket
import sys


class Server:
    def __init__(self, ip, port):
        self.ip = ip
        self.port = port
        self.connect()
        self.output_file()

    def connect(self):
        self.sock = socket.socket()
        self.sock.bind((self.ip, self.port))
        self.sock.listen(1)
        self.conn, self.addr = self.sock.accept()

    def output_file(self):
        self.file_name = input('enter file name   :')
        self.data = open('public/'+self.file_name, 'rb')
        self.conn.send((bytes(self.file_name, encoding='UTF-8')))
        l = self.data.read(1024)
        while (l):
            self.conn.send(l)
            l = self.data.read(1024)

    def logic(self):
        self.name_fail = (self.sock.recv(1024)).decode('UTF-8')


test = Server("localhost", 9999)
