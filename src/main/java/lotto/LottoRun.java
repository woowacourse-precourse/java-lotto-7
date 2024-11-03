package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoRun {
    public static void start() {
        LottoController lottoController = null;
        try {
            lottoController = configure();
        } catch (IllegalAccessError e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController = configure();
        }
        try {
            lottoController.setAndPrintLottos();
        } catch (IllegalAccessError e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController.setAndPrintLottos();
        }
        try {
            lottoController.inputAndConfirmWinningNumber();
        } catch (IllegalAccessError e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController.inputAndConfirmWinningNumber();
        }
        try {
            lottoController.printAndCalculateWinningRate();
        } catch (IllegalAccessError e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController.printAndCalculateWinningRate();
        }
    }

    private static LottoController configure() {
        Lottos lottos = new Lottos();
        LottoView view = new LottoView();
        LottoValue lottoValue = new LottoValue(view.inputLottoPrice());
        return new LottoController(lottos, view, lottoValue);
    }
}
