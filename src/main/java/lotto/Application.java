package lotto;

import java.math.BigDecimal;
import lotto.controller.LottoController;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        Lottos lottos = new Lottos();
        LottoView view = new LottoView();
        LottoController lottoController = new LottoController(lottos, view);
        BigDecimal lottoPrice = lottoController.startLotto();
        lottoController.winningNumber(lottoPrice);
    }
}