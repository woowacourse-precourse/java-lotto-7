package lotto.mvc;

import lotto.constant.RequestUrl;

public class Request {

    private RequestUrl url;

    private Request() {}

    public Request(RequestUrl requestUrl) {
        this.url = requestUrl;
    }

    public RequestUrl getUrl() {
        return url;
    }
}
