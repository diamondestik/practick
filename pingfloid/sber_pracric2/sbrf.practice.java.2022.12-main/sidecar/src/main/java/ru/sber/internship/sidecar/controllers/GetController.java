package ru.sber.internship.sidecar.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.internship.sidecar.models.studentClass;

import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class GetController {

    public String str = "/n";

    @GetMapping("file")
    public String fileRequest(@RequestParam("filepath") String filePath)
    {
        String fileData = null;
        try
        {
            FileInputStream inputStream = new FileInputStream(filePath);
//            inputStream = new FileInputStream("/var/tmp/Test.txt");
            int i = -1;
           fileData = new String(inputStream.readAllBytes(), "UTF-8");
//            byte[] fileMes = inputStream.readAllBytes();
            while ((i = inputStream.read()) != -1) {
                System.out.print((char)i);
            }


        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(fileData);
        return fileData;
    }
    @GetMapping("/home")
    public String str()
    {
        return "Hello world!";
    }

}
