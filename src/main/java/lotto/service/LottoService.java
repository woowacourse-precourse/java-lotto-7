package lotto.service;

import lotto.lotto.Lotto;
import lotto.utils.PurchaseAmount;

import java.util.List;

public class LottoService {

    private final Lotto lotto;

    public LottoService(Lotto lotto) {
        this.lotto = lotto;
    }

    public static int calculateNumberOfLotteryTickets(String purchaseAmountInput) {
        PurchaseAmount.validateInput(purchaseAmountInput);
        int castedPurchaseAmount = PurchaseAmount.validatePurchaseAmount(purchaseAmountInput);
        int numberOfTickets = PurchaseAmount.calculateNumberOfLotteryTickets(castedPurchaseAmount);

        return numberOfTickets;
    }

    public static List<List<Integer>> makeLotteryTickets(int numberOfTickets) {
        List<List<Integer>> lotteryTickets = Lotto.generateLotteryTickets(numberOfTickets);
        return lotteryTickets;
    }

}
