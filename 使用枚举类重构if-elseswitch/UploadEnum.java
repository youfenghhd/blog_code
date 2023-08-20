package com.youfeng.blog;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @author -侑枫
 * @date 2023/8/15 23:43:35
 */
public enum UploadEnum implements UploadService {
    upload1("audio") {
        @Override
        public Boolean uploadByType(MultipartFile file) {
            String url = "url1";
            System.out.println("文件类型为：" + upload1.fileType + " 已上传至：" + url);
            return upload(file, url);
        }
    },
    upload2("video") {
        @Override
        public Boolean uploadByType(MultipartFile file) {
            String url = "url2";
            System.out.println("文件类型为：" + upload2.fileType + " 已上传至：" + url);
            return upload(file, url);
        }
    },
    upload3("image") {
        @Override
        public Boolean uploadByType(MultipartFile file) {
            String url = "url3";
            System.out.println("文件类型为：" + upload3.fileType + " 已上传至：" + url);
            return upload(file, url);
        }
    },
    upload4("other") {
        @Override
        public Boolean uploadByType(MultipartFile file) {
            String url = "url4";
            System.out.println("文件类型为：" + upload4.fileType + " 已上传至：" + url);
            return upload(file, url);
        }
    };

    private final String fileType;

    UploadEnum(String fileType) {
        this.fileType = fileType;
    }

    public static boolean upload(MultipartFile file, String url) {
        return true;
    }

    public static UploadService handler(String fileType) {
        for (UploadEnum uploadEnum : UploadEnum.values()) {
            if (Objects.equals(uploadEnum.fileType, fileType)) {
                return uploadEnum;
            }
        }

        throw new RuntimeException("文件类型非法！");
    }
}
