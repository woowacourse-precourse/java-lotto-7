package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoRun {
    public static void start() {
        LottoController lottoController = configure();
        lottoController.setAndPrintLottos();
        lottoController.inputAndConfirmWinningNumber();
        lottoController.printAndCalculateWinningRate();
    }

    private static LottoController configure() {
        Lottos lottos = new Lottos();
        LottoView view = new LottoView();
        LottoValue lottoValue = new LottoValue(view.inputLottoPrice());
        return new LottoController(lottos, view, lottoValue);
    }
}
