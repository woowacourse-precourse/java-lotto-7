package lotto;

import lotto.mvc.controller.LottoController;
import lotto.mvc.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView());

        lottoController.run();

        String s = "-1111111111111111111111";

        long lon = Long.parseLong(s);

        System.out.println("lon = " + lon);
    }
}
