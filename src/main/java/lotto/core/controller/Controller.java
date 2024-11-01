package lotto.core.controller;

public interface Controller<Request, Response> {

    Response request(Request request);

}
