package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.LottoChecker;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private Input purchaseAmountInput;
    private Input winningNumbersInput;
    private Input bonusNumberInput;
    private Output output;
    private LottoGenerator generator;
    private LottoChecker checker;

    public LottoController(Input purchaseAmountInput, Input winningNumbersInput, Input bonusNumberInput, Output output,
                           LottoGenerator generator, LottoChecker checker) {
        this.purchaseAmountInput = purchaseAmountInput;
        this.winningNumbersInput = winningNumbersInput;
        this.bonusNumberInput = bonusNumberInput;
        this.output = output;
        this.generator = generator;
        this.checker = checker;
    }

    public void run() {
        try {
            int purchaseAmount = (int) purchaseAmountInput.input();
            output.printLottoNumbers(
                    generator.generateLottos(purchaseAmount).getPurchasedLottos()
            );
            checker.setWinningNumbers((Lotto) winningNumbersInput.input(), (Integer) bonusNumberInput.input());


        } finally {
            Console.close();
        }
    }
}
