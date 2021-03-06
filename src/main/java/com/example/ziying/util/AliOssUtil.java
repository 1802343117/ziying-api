package com.example.ziying.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/1
 */
@Slf4j
public class AliOssUtil {
    public static String upload(MultipartFile sourceFile){
        // 获取文件名
        String fileName = sourceFile.getOriginalFilename();
        System.out.println(fileName);
        //uuid生成主文件名
        String prefix = UUID.randomUUID().toString();
        assert fileName != null;
        //源文件的扩展名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
        //创建File类型的临时文件
        File tempFile = null;
        try {
            tempFile = File.createTempFile(prefix,suffix);
            //将MultipartFile转换成File
            sourceFile.transferTo(tempFile);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        assert tempFile != null;
        return upload(tempFile);
    }
    public static String upload(File file){
        String endpoint = "https://oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI4G6ZUhpAyJPE7gMG1mdw";
        String accessKeySecret = "kg0bcSp4eGN7j9ifqiSvqv14pBWOfV";
        String bucketName = "tunlmusic";
        String filePath = "";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        //创建OSSClient实例
//        OSSClient ossClient  = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        OSS ossClient  = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        //上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName,filePath + newFileName,file);
        //拼接URL
        String url = "https://tunlmusic.oss-cn-shenzhen.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }
    public static void main(String[] args) {
        File file = new File("F:/Figure/1.jpg");
        upload(file);
        System.out.println(upload(file));
    }
}