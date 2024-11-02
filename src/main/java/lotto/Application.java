package lotto;

import static lotto.constant.RequestUrl.*;

import lotto.controller.DispatcherServlet;
import lotto.mvc.Request;

public class Application {
    public static void main(String[] args) {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.doService(new Request(PURCHASE_RANDOM_LOTTO));
        servlet.doService(new Request(INIT_WINNING_LOTTO));
        servlet.doService(new Request(CALCULATE_RESULT));
    }
}
