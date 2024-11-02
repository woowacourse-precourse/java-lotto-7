package lotto.controller;

import lotto.Bag;
import lotto.LotteryMachine;
import lotto.User;
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
}
