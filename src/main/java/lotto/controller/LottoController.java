package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.*;
import lotto.input.*;
import lotto.service.*;
import lotto.view.*;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseCount = setPurchaseCount();
        outputView.printLottoCount(purchaseCount);
        Lottos lottos = lottoService.generateLottos(purchaseCount);
        outputView.printLottoNumbers(lottos);
        WinningLotto winningLotto = setWinningLotto();
        Console.close();

        ResultCalculator resultCalculator = lottoService.calculateResult(lottos, winningLotto);

        outputView.printWinningDetails(resultCalculator);
        outputView.printYield(resultCalculator.calculateRate(purchaseCount * 1000));
    }

    private int setPurchaseCount() {
        while (true) {
            String purchaseAmount = inputView.getPurchaseAmount();
            try {
                return PurchaseAmountProcessor.calculatePurchaseCount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private WinningLotto setWinningLotto() {
        while (true) {
            try {
                Lotto lotto = setLotto();
                int bonusNum = setBonusNumber();
                return new WinningLotto(lotto, bonusNum);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private Lotto setLotto() {
        while (true) {
            try {
                String winNumbers = inputView.getWinningNumber();
                List<Integer> winningNumbers = WinningNumberProcessor.processWinningNumbers(winNumbers);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private int setBonusNumber() {
        while (true) {
            try {
                String bonusNumber = inputView.getBonusNumber();
                return BonusNumberProcessor.validateAndParse(bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }


}
