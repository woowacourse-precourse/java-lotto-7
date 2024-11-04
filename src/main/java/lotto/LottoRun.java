package lotto;

import java.util.List;
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
        int bonusNumber = bonusNumber(lottoController);
        WinningValue winningValue = new WinningValue(winningNumbers, bonusNumber);
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

    private static int bonusNumber(LottoController lottoController) {
        int bonusNumber = 0;
        try {
            bonusNumber = lottoController.getBonusNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return bonusNumber(lottoController);
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
