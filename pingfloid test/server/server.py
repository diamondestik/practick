import socket
import sys
import os
import fnmatch


class Server:
    def __init__(self, ip, port):
        self.ip = ip
        self.port = port
        self.logic()

    def connect(self):
        self.sock = socket.socket()
        self.sock.bind((self.ip, self.port))
        self.sock.listen(1)
        self.conn, self.addr = self.sock.accept()
        print(self.conn)

    def output_file(self):
        self.file_name = input('enter file name   :')
        self.data = open('public/' + self.file_name, 'rb')
        self.conn.send((bytes(self.file_name, encoding='UTF-8')))
        l = self.data.read(1024)
        while (l):
            self.conn.send(l)
            l = self.data.read(1024)
    def output_all_file(self):
        for file in self.listOfFiles:
            self.file_name = file
            self.data = open('public/' + self.file_name, 'rb')
            self.conn.send((bytes(self.file_name, encoding='UTF-8')))
            l = self.data.read(1024)
            while (l):
                self.conn.send(l)
                l = self.data.read(1024)

    def list_file_in_directory(self):
        self.listOfFiles = os.listdir('public')
        while (self.listOfFiles):
            self.conn.send(self.listOfFiles)

        print('list')

    def logic(self):
        self.connect()
        self.input_function = str(self.conn.recv(1024).decode('UTF-8'))
        if self.input_function == 'conn':
            self.connect()
        elif self.input_function == 'input':
            self.output_file()
        elif self.input_function == 'output_all':
            pass
        elif self.input_function == 'list_file_in_directory':
            self.list_file_in_directory()



test = Server("localhost", 9999)
