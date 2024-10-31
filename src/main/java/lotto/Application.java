package lotto;

import lotto.controller.LottoController;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        Lottos lottos = new Lottos();
        LottoController lottoController = new LottoController(lottos);
        LottoView view = new LottoView(lottoController);
        view.startLotto();
    }
}