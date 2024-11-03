package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    private LottoGenerator generator = new LottoGenerator();
    private Input purchaseAmountInput;
    private Input winningNumbersInput;
    private Output output;

    public LottoController(Input purchaseAmountInput, Input winningNumbersInput, Output output) {
        this.purchaseAmountInput = purchaseAmountInput;
        this.winningNumbersInput = winningNumbersInput;
        this.output = output;
    }

    public void run() {
        try {
            int purchaseAmount = purchaseAmountInput.input();
            int numberOfLottos = purchaseAmount / 1000; // TODO
            List<Lotto> purchasedLottos = generator.generateLottos(numberOfLottos);
            output.printLottoNumbers(purchasedLottos);
        } finally {
            Console.close();
        }
    }
}
