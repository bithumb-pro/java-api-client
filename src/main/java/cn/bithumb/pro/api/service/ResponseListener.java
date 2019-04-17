package cn.bithumb.pro.api.service;

public interface ResponseListener<T> {

    void onResponse(T msg);
}
