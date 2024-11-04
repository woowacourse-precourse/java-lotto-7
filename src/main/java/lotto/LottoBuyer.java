package lotto;

import input.InputProcessor;
import input.LottoPurchaseAmountInputProcessor;
import java.util.ArrayList;

public class LottoBuyer {

    private final InputProcessor<Integer> lottoPurchaseAmountInputProcessor;
    private final LottoVendingMachine lottoVendingMachine;
    private Integer lottoPurchaseAmount;
    private ArrayList<Lotto> lottoTickets;

    public LottoBuyer(LottoPurchaseAmountInputProcessor lottoPurchaseAmountInput,
            LottoVendingMachine lottoVendingMachine) {
        this.lottoPurchaseAmountInputProcessor = lottoPurchaseAmountInput;
        this.lottoVendingMachine = lottoVendingMachine;
    }

    public ArrayList<Lotto> purchaseLotto() {
        insertCoin();
        lottoTickets = lottoVendingMachine.giveLotto(lottoPurchaseAmount);
        printOwnLottoTickets();
        return lottoTickets;
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

    public int ownLottoTicketCount(){
        return lottoTickets.size();
    }
}
