package lotto.controller;

import lotto.mvc.HandlerMapper;
import lotto.mvc.Request;
import lotto.view.View;
import lotto.view.VoidView;

public class DispatcherServlet {

    private final HandlerMapper handlerMapper;

    public DispatcherServlet() {
        this.handlerMapper = new HandlerMapper();
    }

    public void doService(Request request) {
        Controller controller = handlerMapper.getController(request.getUrl());
        View view = controller.execute();
        forward(view);
    }

    private void forward(View view) {
        if (view instanceof VoidView) {
            return;
        }
        System.out.println(view.render());
    }
}
