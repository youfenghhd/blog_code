package com.youfeng.blog;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author -侑枫
 * @date 2023/8/15 23:36:26
 */
public interface UploadService {
    /**
     * 上传文件的方法
     *
     * @param file 文件
     * @return
     */
    Boolean uploadByType(MultipartFile file);
}
