package org.example.buoi3.configs;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary configCloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dxv6likvh");
        config.put("api_key", "445523463769129");
        config.put("api_secret", "QnlnqAREeaqEY88I3L137_8FurU");
        return new Cloudinary(config);
    }
}
