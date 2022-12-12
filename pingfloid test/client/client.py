import socket
import sys


class Client:
    def __init__(self, ip, port):
        self.ip = ip
        self.port = port
        self.connect()
        self.input_file()

    def connect(self):
        self.sock = socket.socket()
        self.sock.connect((self.ip, self.port))

    def input_file(self):
        # получаем название файла
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


test = Client("localhost", 9999)
