package com.example.inventory.handler.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private LocalDateTime timestamp;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private List<Field> fields;

    public Problem() {

    }

    public static class Field{

        private String name;


        private String userMessage;

        public Field(){

        }

        public Field(String name, String userMessage){
            this.name = name;
            this.userMessage = userMessage;

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

        public Field withBuilderUserMessage(String userMessage){
            setUserMessage(userMessage);
            return this;
        }

        public Field withBuilderName(String name){
            setName(name);
            return this;
        }
    }


    public Problem(Integer status, LocalDateTime timestamp, String type, String title,
                   String detail, String userMessage){
        this.status = status;
        this.timestamp = timestamp;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.userMessage = userMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserMessage() {
        return userMessage;
    }
    public Integer getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Problem withBuilderStatus(Integer status){
        setStatus(status);
        return this;
    }
    public Problem withBuilderTimestamp(LocalDateTime timestamp){
        setTimestamp(timestamp);
        return this;
    }

    public Problem withBuilderType(String type){
        setType(type);
        return this;
    }

    public Problem withBuilderTitle(String title){
        setTitle(title);
        return this;
    }

    public Problem withBuilderDetail(String detail){
        setDetail(detail);
        return this;
    }

    public Problem withBuilderUserMessage(String userMessage){
        setUserMessage(userMessage);
        return this;
    }

    public Problem withBuilderFields(List<Field> fields){
        setFields(fields);
        return this;
    }

}
