package com.caballerosalas.gltest.errorhandling;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.Date;

public class ErrorResponse {
    // customizing timestamp serialization format
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String detail;


    // g and s
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public ErrorResponse() {
        timestamp = new Date();
    }


    public ErrorResponse(
            HttpStatus httpStatus,
            String detail
    ) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.detail = detail;
    }


}
