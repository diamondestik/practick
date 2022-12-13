import socket
import sys


class Client:
    def __init__(self, ip, port):
        self.ip = ip
        self.port = port
        self.logic()

    def connect(self):
        self.sock = socket.socket()
        self.sock.connect((self.ip, self.port))

    def input_file(self):
        # получаем название файла
        self.len_list_file = []
        self.name_fail = (self.sock.recv(1024)).decode('UTF-8')

        # открываем файл в режиме байтовой записи в отдельной папке 'sent'
        f = open('public/' + self.name_fail, 'wb')

        while True:

            # получаем байтовые строки
            l = self.sock.recv(1024)

            # пишем байтовые строки в файл на сервере
            f.write(l)

            if not l:
                break
    def input_all_file(self):
        # получаем название файла
        self.len_list_file = []
        self.name_fail = (self.sock.recv(1024)).decode('UTF-8')

        # открываем файл в режиме байтовой записи в отдельной папке 'sent'
        f = open('public/' + self.name_fail, 'wb')

        while True:

            # получаем байтовые строки
            l = self.sock.recv(1024)

            # пишем байтовые строки в файл на сервере
            

            if not l:
                break
    def input_list(self,command):
        self.sock.send((bytes(command, encoding='UTF-8')))
        while True:

            # получаем байтовые строки
            self.len_list_file.append(self.sock.recv(1024))

            # пишем байтовые строки в файл на сервере


            if not self.len_list_file:
                break
        print(self.len_list_file)
    def logic(self):
        self.sost = True
        while self.sost:
            print('conn                :connect server')
            print('input               :input one file')
            print('input_all           :input all files')
            print('list                :list_file_in_directory')
            self.command = input('enter your command  :>')
            if self.command.lower() == 'conn':
                self.connect()
            elif self.command.lower() == 'input':
                self.input_file()
            elif self.command.lower() == 'input_all':
                self.input_all_file()
            elif self.command.lower() == 'list':
                self.input_list('list_file_in_directory')
            else:
                print('комманда введена не правильно')


test = Client("localhost", 9999)
