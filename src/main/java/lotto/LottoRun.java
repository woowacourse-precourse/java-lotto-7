package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.view.LottoView;

public class LottoRun {
    public static void start() {
        LottoController lottoController = init();
        set(lottoController);
        List<Integer> winningNumber = winningNumber(lottoController);
        int bonusNumber = bonusNumber(lottoController);
        lottoController.confirmWinning(winningNumber, bonusNumber);
        winningRate(lottoController);
    }

    private static void winningRate(LottoController lottoController) {
        try {
            lottoController.printAndCalculateWinningRate();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController.printAndCalculateWinningRate();
        }
    }

    private static int bonusNumber(LottoController lottoController) {
        int bonusNumber = 0;
        try {
            bonusNumber = lottoController.getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            bonusNumber = lottoController.getBonusNumber();
        }
        return bonusNumber;
    }

    private static List<Integer> winningNumber(LottoController lottoController) {
        List<Integer> winningNumber = null;
        try {
            winningNumber = lottoController.getWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            winningNumber = lottoController.getWinningNumber();
        }
        return winningNumber;
    }

    private static void set(LottoController lottoController) {
        try {
            lottoController.setAndPrintLottos();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController.setAndPrintLottos();
        }
    }

    private static LottoController init() {
        LottoController lottoController = null;
        try {
            lottoController = configure();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            lottoController = configure();
        }
        return lottoController;
    }

    private static LottoController configure() {
        Lottos lottos = new Lottos();
        LottoView view = new LottoView();
        LottoValue lottoValue = new LottoValue(view.inputLottoPrice());
        return new LottoController(lottos, view, lottoValue);
    }
}
