package lotto.controller;

import lotto.Bag;
import lotto.LotteryMachine;
import lotto.view.InputView;
import lotto.view.outputView;

public class LottoController {
    private LotteryMachine lotteryMachine;

    public LottoController() {
        lotteryMachine = new LotteryMachine();
    }
    public void run() {
        startLottoPurchase();

    }

    public void startLottoPurchase() {
        while(true) {
            try {
                Bag bag = InputView.inputPurchaseAmount();
                lotteryMachine.purchaseLottoTickets(bag);
                outputView.printPurchasedLottoTickets(bag);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
