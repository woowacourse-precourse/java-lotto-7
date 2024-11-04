package lotto;

import lotto.controller.LottoAppController;
import lotto.model.draw_numbers.DrawNumbers;
import lotto.model.lotto.Lotto;

import java.util.List;

public class LottoApp {

    private final LottoAppController lottoAppController;

    public LottoApp(LottoAppController lottoAppController) {
        this.lottoAppController = lottoAppController;
    }

    public void start() {
        List<Lotto> lottos = lottoAppController.buyLottos();
        DrawNumbers drawNumbers = lottoAppController.draw();
        lottoAppController.printResult(lottos, drawNumbers);
    }
}
