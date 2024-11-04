package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.Input;
import lotto.view.Output;
import lotto.utils.LottoUtils;

import java.util.List;

public class LottoController {
    private final Input input;
    private final Output output;

    public LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        int purchaseAmount = input.getPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        output.printLottoTickets(lottoMachine.generateLottos());

        List<Integer> winningNumbers = LottoUtils.parseNumbers(input.getWinningNumbers());
        int bonusNumber = input.getBonusNumber();

        lottoMachine.calculateResults(winningNumbers, bonusNumber);
        output.printStatistics(lottoMachine.getStatistics());
    }
}
