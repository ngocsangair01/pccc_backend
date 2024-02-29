package org.example.buoi3.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestData<T> {
    private RestStatus restStatus;

    private String message;

    private List<String> reasons;

    private T data;


    /**
     * Dùng khi get data thành công, thì reasons sẽ trả về null**/
    public RestData(String message, T data) {
        this.restStatus = RestStatus.SUCCESS;
        this.message = message;
        this.data = data;
    }

    /**
     * Dùng khi get data thất bại, thì data sẽ null, reasons sẽ có**/
    public RestData( String message, List<String> reasons) {
        this.restStatus = RestStatus.ERROR;
        this.message = message;
        this.reasons = reasons;
    }

    public RestStatus getRestStatus() {
        return restStatus;
    }

    public void setRestStatus(RestStatus restStatus) {
        this.restStatus = restStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public void setReasons(List<String> reasons) {
        this.reasons = reasons;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RestData(RestStatus restStatus, String message, List<String> reasons, T data) {
        this.restStatus = restStatus;
        this.message = message;
        this.reasons = reasons;
        this.data = data;
    }
}
