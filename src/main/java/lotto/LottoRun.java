package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoValue;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningValue;
import lotto.view.LottoView;

public class LottoRun {
    public static void start() {
        LottoController lottoController = init();
        set(lottoController);
        WinningNumbers winningNumbers = winningNumber(lottoController);
        WinningValue winningValue = bonusNumber(lottoController, winningNumbers);
        lottoController.confirmWinning(winningValue);
        winningRate(lottoController);
    }

    private static void winningRate(LottoController lottoController) {
        try {
            lottoController.printAndCalculateWinningRate();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            winningRate(lottoController);
        }
    }

    private static WinningValue bonusNumber(LottoController lottoController, WinningNumbers winningNumbers) {
        WinningValue winningValue = null;
        try {
            int bonusNumber = lottoController.getBonusNumber();
            return new WinningValue(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return bonusNumber(lottoController, winningNumbers);
        }
    }

    private static WinningNumbers winningNumber(LottoController lottoController) {
        WinningNumbers winningNumbers = null;
        try {
            winningNumbers = lottoController.getWinningNumber();
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return winningNumber(lottoController);
        }
    }

    private static void set(LottoController lottoController) {
        try {
            lottoController.setAndPrintLottos();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            set(lottoController);
        }
    }

    private static LottoController init() {
        LottoController lottoController = null;
        try {
            lottoController = configure();
            return lottoController;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return init();
        }
    }

    private static LottoController configure() {
        Lottos lottos = new Lottos();
        LottoView view = new LottoView();
        LottoValue lottoValue = new LottoValue(view.inputLottoPrice());
        return new LottoController(lottos, view, lottoValue);
    }
}