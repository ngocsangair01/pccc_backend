package org.example.buoi3.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {
    /**
     * Sử dụng khi lấy data thành công
     * **/
    public static ResponseEntity<?> restSuccess(Object data){
        RestData<?> restData = new RestData<>("Success",data);
        return ResponseEntity.ok(restData);
    }

    /**
     * Sử dụng khi lấy data không thành công
     * **/
    public static ResponseEntity<RestData<?>> error(HttpStatus status,List<String> message){
        RestData<?> restData = new RestData<>("Error",message);
        return new ResponseEntity<>(restData,status);
    }
}
