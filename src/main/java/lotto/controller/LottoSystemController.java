package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Machine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystemController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoSystemController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Machine machine = null;
        while (machine == null) {
            try {
                machine = new Machine(inputView.inputAmount());
                machine.publishLotto(machine.getMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.outputPurchaseLottoNumber(machine.getMoney(), machine.getLotteryTickets());

        Lotto lotto = null;
        while (lotto == null) {
            try {
                String input = inputView.inputLottoWinningNumber();
                lotto = new Lotto(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean isBonusNumberValid = false;
        while (!isBonusNumberValid) {
            try {
                lotto.matcheNumber(machine.getLotteryTickets(), inputView.inputBonusNumber());
                isBonusNumberValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        outputView.outputLottoWinningStatistics();
        outputView.outputLateOfReturn(machine.lateOfReturn());
    }
}
