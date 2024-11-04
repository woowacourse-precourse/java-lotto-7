package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoServiceImpl;
import lotto.view.ConsoleLottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoServiceImpl(), new ConsoleLottoView());
        lottoController.run();
    }
}
