package com.heima.minio.test;


import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {

    @Autowired
    private FileStorageService fileStorageService;

    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\自制html集锦\\动漫.html");
        String path = fileStorageService.uploadHtmlFile("", "cartoon.html", fileInputStream);
        System.out.println(path);
    }


    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\学习\\java面试\\黑马头条\\day02-app端文章查看，静态化freemarker,分布式文件系统minIO\\资料\\模板文件\\plugins\\js\\axios.min.js");

            // 1.获取minio的链接信息，创建一个minio的客户端
            MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123")
                    .endpoint("http://192.168.200.130:9000").build();
            // 2. 上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("plugins/js/axios.min.js") // 文件名称
                    .contentType("text/axios.min.js") // 文件类型
                    .bucket("leadnews") // 桶的名称 与minio管理界面创建的桶一致
                    .stream(fileInputStream, fileInputStream.available(), -1).build();
            minioClient.putObject(putObjectArgs);
//            System.out.println("http://192.168.200.130:9000/leadnews/动漫.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}