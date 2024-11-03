package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private LottoGenerator generator;
    private Input purchaseAmountInput;
    private Input winningNumbersInput;
    private Output output;

    public LottoController(Input purchaseAmountInput, Input winningNumbersInput, Output output,
                           LottoGenerator generator) {
        this.purchaseAmountInput = purchaseAmountInput;
        this.winningNumbersInput = winningNumbersInput;
        this.output = output;
        this.generator = generator;
    }

    public void run() {
        try {
            int purchaseAmount = purchaseAmountInput.input();
            output.printLottoNumbers(
                    generator.generateLottos(purchaseAmount).getPurchasedLottos()
            );
            String winningNumbers = winningNumbersInput.input();


        } finally {
            Console.close();
        }
    }
}
