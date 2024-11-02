package lotto.mvc;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.RequestUrl;
import lotto.controller.Controller;

public class HandlerMapper {

    private final static Map<RequestUrl, Controller> CONTROLLER_MAP = new HashMap<>();

    public Controller getController(RequestUrl url) {
        return CONTROLLER_MAP.get(url);
    }
}
