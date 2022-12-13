package ru.sber.internship.sidecar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.internship.sidecar.models.fileClass;
import ru.sber.internship.sidecar.models.studentClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class GetController {

    //!!!!!! ВСЕ ЗАПРОСЫ ОТПРАВЛЯЮТСЯ ИЗ ВТОРОГО ПРОЕКТА - sber_request2!!!!!

    @GetMapping("/file") // маппинг который возвращает единную строку данных элементов
    public String fileRequest()
    {
        String fileData = null; // буфер для данных файлов
        String filesHeap = null; // *куча* для всех данных файлов

        //подключение директории. можно указать любую директорию в которой есть файлы для чтения
        File directory = new File("/var/tmp/sber_local_dir/");


        for (File file : directory.listFiles()) // цикл проверяющий каждый файл в директории и складывающий его в переменную file
        {
            try
            {
            FileInputStream inputStream = new FileInputStream(file);
            fileData = new String(inputStream.readAllBytes(), "UTF-8"); //чтение файла и сохранение в переменную
            filesHeap += file.getName()+"\n"+ fileData+"//";

//            int i = -1;
//            byte[] fileMes = inputStream.readAllBytes();
//            while ((i = inputStream.read()) != -1)
//            {
//                System.out.print((char)i);
//            }


            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println("Имя файла: "+ file.getName()+" Содержание: "+ fileData);
        }

        return filesHeap;
    }
    @GetMapping("/file_mas") // маппинг который возвращает массив classFile объектов
    public fileClass[] fileRequestMas()
    {
        //создание массива объектов класса, максимальное количество файлов которых необходимо прописывать вручную
        fileClass[] filesArray = new fileClass[4];

        //объявление полей, т.к. массив хранит ссылки и не может обращаться к элементам хранящим null??
//        filesArray[0] = new fileClass("test","test","test");
//        filesArray[1] = new fileClass("test","test","test");
//        filesArray[2] = new fileClass("test","test","test");
//        filesArray[3] = new fileClass("test","test","test");

//        for(int j = 0; j<filesArray.length; j++)
//        {
//            filesArray[j] = new fileClass("test","test","test");
//        }


//            System.out.println("new version!!");
        File directory = new File("/var/tmp/sber_local_dir/"); //подключение директории

        int i = 0; //счетчик для массива filesArray

        for (File file : directory.listFiles())
        {
            try
            {
                // создание потока ввода
                FileInputStream inputStream = new FileInputStream(file);

                // через конструктор класса задаются поля... контент файла подтягивается через FileInputStream
                filesArray[i] = new fileClass(file.getName(),file.getPath(),new String(inputStream.readAllBytes(), "UTF-8"));
            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            i++;
        }
        return filesArray;
    }







// тестовые мапинги
    @GetMapping("/home")
    public String str()
    {
        return "Hello world!";
    }

    @GetMapping("/students")
    public studentClass getStudent()
    {
        studentClass student =  new studentClass();
        student.setName("Sygizmund");
        student.setGroupe("220");
        student.setAvarageScore("0.2");

        return student;
    }

}
