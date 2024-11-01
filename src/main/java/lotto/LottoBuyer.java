package lotto;

import input.Input;
import input.LottoPurchaseAmountInput;
import java.util.ArrayList;

public class LottoBuyer {

    private final Input<Integer> lottoPurchaseAmountInput;
    private final LottoVendingMachine lottoVendingMachine;
    private Integer lottoPurchaseAmount;
    private ArrayList<Lotto> lottoTickets;

    LottoBuyer(LottoPurchaseAmountInput lottoPurchaseAmountInput,
            LottoVendingMachine lottoVendingMachine) {
        this.lottoPurchaseAmountInput = lottoPurchaseAmountInput;
        this.lottoVendingMachine = lottoVendingMachine;
    }

    public void purchaseLotto() {
        insertCoin();
        lottoTickets = lottoVendingMachine.giveLotto(lottoPurchaseAmount);
        printOwnLottoTickets();
    }

    public void insertCoin() {
        lottoPurchaseAmount = lottoPurchaseAmountInput.putValue();
    }

    public void printOwnLottoTickets() {
        for (Lotto lottoTicket : lottoTickets) {
            lottoTicket.show();
        }
        System.out.println();
    }
}
