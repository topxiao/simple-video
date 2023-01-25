package com.zyarn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 文件上传记录
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileRecordDO {

    /**
     * 文件id
     */
    private Long id;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件url
     */
    private String fileUrl;

    /**
     * 文件类型
     * 0：视频
     * 1：图片
     */
    private String fileType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
