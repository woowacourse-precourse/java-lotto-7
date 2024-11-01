package lotto.controller;

public interface Controller<T> {

    void process();

    T getResponse();

}
