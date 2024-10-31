package lotto;

import input.Input;
import input.LottoPurchaseAmountInput;
import java.util.ArrayList;

public class LottoBuyer {

    private final Input<Integer> lottoPurchaseAmountInput;
    private Integer lottoPurchaseAmount;
    private ArrayList<Lotto> lottoTickets;

    LottoBuyer(LottoPurchaseAmountInput lottoPurchaseAmountInput) {
        this.lottoPurchaseAmountInput = lottoPurchaseAmountInput;
    }

    public void purchaseLotto() {
        insertCoin();
    }

    public void insertCoin() {
        lottoPurchaseAmount = lottoPurchaseAmountInput.putValue();
    }
}
