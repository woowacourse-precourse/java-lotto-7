package lotto.controller;

import lotto.dto.Result;
import lotto.domain.LotteryMachine;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.outputView;

public class LottoController {
    private LotteryMachine lotteryMachine;
    private User user;

    public LottoController() {
        lotteryMachine = new LotteryMachine();
    }
    public void run() {
        startLottoPurchase();
    }

    public void startLottoPurchase() {
        while(true) {
            try {
                user = new User(InputView.inputPurchaseAmount());
                lotteryMachine.purchaseLottoTickets(user);
                outputView.printPurchasedLottoTickets(user.getBag());
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void inputWinningNumbers() {
        while(true) {
            try{
                Result result = new Result(InputView.inputWinningNumbers());
                result.setBonusNumber(InputView.inputBonusNumber());

                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
