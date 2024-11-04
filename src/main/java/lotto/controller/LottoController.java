package lotto.controller;

import static lotto.constant.LottoConstants.PURCHASE_UNIT;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.service.*;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoService lottoService;

    public LottoController(Input input, Output output, LottoService lottoService) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseCount = setPurchaseCount();
        output.printLottoCount(purchaseCount);
        Lottos lottos = lottoService.generateLottos(purchaseCount);
        output.printLottoNumbers(lottos);
        WinningLotto winningLotto = setWinningLotto();
        Console.close();

        ResultCalculator resultCalculator = lottoService.calculateResult(lottos, winningLotto);

        output.printWinningDetails(resultCalculator);
        output.printYield(resultCalculator.calculateRate(purchaseCount * PURCHASE_UNIT));
    }

    private int setPurchaseCount() {
        while (true) {
            String purchaseAmount = input.getPurchaseAmount();
            try {
                return lottoService.getValidPurchaseCount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e.getMessage());
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
                output.printExceptionMessage(e.getMessage());
            }
        }
    }

    private Lotto setLotto() {
        while (true) {
            try {
                String winNumbers = input.getWinningNumber();
                return lottoService.getValidLotto(winNumbers);
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e.getMessage());
            }
        }
    }

    private int setBonusNumber() {
        while (true) {
            try {
                String bonusNumber = input.getBonusNumber();
                return lottoService.getValidBonusNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e.getMessage());
            }
        }
    }
}
