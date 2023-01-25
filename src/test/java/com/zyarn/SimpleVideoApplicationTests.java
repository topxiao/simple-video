package com.zyarn;

import com.zyarn.entity.FileRecordDO;
import com.zyarn.utils.MinioUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
class SimpleVideoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    private static final String prefix = "C:\\Users\\RaWal\\Videos\\QQplayerClip\\";



    @Test
    void testUpload() throws IOException {
        // 获取文件夹下的所有文件
        File file = new File(prefix);
        File[] files = file.listFiles();

        // 遍历文件夹下的所有文件，上传到minio
        for (File f : files) {
            System.out.println(f.getName());
            String uploadFile = MinioUtil.uploadFile("assets", f.getName(), new FileInputStream(f));
            FileRecordDO fileRecord = new FileRecordDO();
            fileRecord.setFileName(f.getName());
            fileRecord.setFileUrl(uploadFile);
            fileRecord.setFileType("0");
            String sql = "insert into t_file_record (file_name, file_url, file_type) values (?, ?, ?)";
            jdbcTemplate.update(sql, fileRecord.getFileName(), fileRecord.getFileUrl(), fileRecord.getFileType());
        }

    }

}
