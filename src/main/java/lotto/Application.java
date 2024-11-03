package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView view = new LottoView();
        LottoController lottoController = new LottoController(view);
        lottoController.startLotto();
    }
}
