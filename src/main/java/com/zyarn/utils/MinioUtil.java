package com.zyarn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import org.springframework.web.multipart.MultipartFile;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;

/**
 * Minio 文件存储工具类
 */
public class MinioUtil {
    /**
     * 上传文件
     *
     * @param bucketName 桶名称
     * @param fileName   文件名称
     * @throws IOException
     */
    public static String uploadFile(String bucketName, String fileName, MultipartFile multipartFile) throws IOException {
        String url = "";
        MinioClient minioClient = SpringInit.getBean(MinioClient.class);
        try (InputStream inputStream = multipartFile.getInputStream()) {
            minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(fileName).stream(inputStream, multipartFile.getSize(), -1).contentType(multipartFile.getContentType()).build());
            url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(bucketName).object(fileName).method(Method.GET).build());
            url = url.substring(0, url.indexOf('?'));
            return URLDecoder.decode(url, "UTF-8");
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }
}
