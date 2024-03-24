package org.example.buoi3.utils;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.example.buoi3.models.Image;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UploadFile {

    public static Cloudinary cloudinary;
//
    public UploadFile(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public static String imageToUrl(MultipartFile multipartFile) {
        try {

            Map<?, ?> map = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            return map.get("secure_url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> imagesToUrl(List<MultipartFile> multipartFiles) {
        List<String> images = new ArrayList<>();
        try {
            for (int i = 0; i < multipartFiles.size(); i++) {
                Map<?, ?> map = cloudinary.uploader().upload(multipartFiles.get(i).getBytes(), ObjectUtils.emptyMap());
                String link = map.get("secure_url").toString();
                images.add(link);
            }
            return images;
        } catch (IOException ioException) {
            throw new RuntimeException();
        }

    }
}
