package lotto.controller;

import lotto.model.Lotto;
import lotto.model.User;
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
        User user = null;
        while (user == null) {
            try {
                user = new User(inputView.inputAmount());
                user.publishLotto(user.getMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.outputPurchaseLottoNumber(user.getMoney(), user.getLotteryTickets());

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
                lotto.matcheNumber(user.getLotteryTickets(), inputView.inputBonusNumber());
                isBonusNumberValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        outputView.outputLottoWinningStatistics();
        outputView.outputLateOfReturn(user.lateOfReturn());
    }
}
