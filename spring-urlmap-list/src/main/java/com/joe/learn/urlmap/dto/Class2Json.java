package com.joe.learn.urlmap.dto;

public class Class2Json {
        private String className;
        private String jsonStr;

        public Class2Json(String className, String jsonStr) {
            this.className = className;
            this.jsonStr = jsonStr;
        }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}