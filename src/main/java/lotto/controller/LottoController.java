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
        return validateInput(() -> lottoService.getValidPurchaseCount(input.getPurchaseAmount()));
    }

    private WinningLotto setWinningLotto() {
        return validateInput(() -> lottoService.createWinningLotto(input.getWinningNumber(), input.getBonusNumber()));
    }

    private Lotto setLotto() {
        return validateInput(() -> lottoService.getValidLotto(input.getWinningNumber()));
    }

    private int setBonusNumber() {
        return validateInput(() -> lottoService.getValidBonusNumber(input.getBonusNumber()));
    }

    private <T> T validateInput(InputSupplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                output.printExceptionMessage(e.getMessage());
            }
        }
    }

    @FunctionalInterface
    private interface InputSupplier<T> {
        T get();
    }
}
