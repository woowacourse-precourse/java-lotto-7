package lotto;

import input.InputProcessor;
import input.LottoPurchaseAmountInputProcessor;
import java.util.ArrayList;

public class LottoBuyer {

    private final InputProcessor<Integer> lottoPurchaseAmountInputProcessor;
    private final LottoVendingMachine lottoVendingMachine;
    private Integer lottoPurchaseAmount;
    private ArrayList<Lotto> lottoTickets;

    LottoBuyer(LottoPurchaseAmountInputProcessor lottoPurchaseAmountInput,
            LottoVendingMachine lottoVendingMachine) {
        this.lottoPurchaseAmountInputProcessor = lottoPurchaseAmountInput;
        this.lottoVendingMachine = lottoVendingMachine;
    }

    public void purchaseLotto() {
        insertCoin();
        lottoTickets = lottoVendingMachine.giveLotto(lottoPurchaseAmount);
        printOwnLottoTickets();
    }

    public void insertCoin() {
        lottoPurchaseAmount = lottoPurchaseAmountInputProcessor.putValue();
    }

    public void printOwnLottoTickets() {
        for (Lotto lottoTicket : lottoTickets) {
            lottoTicket.show();
        }
        System.out.println();
    }
}
