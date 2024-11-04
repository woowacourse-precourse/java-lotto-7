package lotto;

import lotto.constant.Amount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchaseDetails {

    private int purchaseAmount;
    private List<List<Integer>> lottoTickets = new ArrayList<>();

    public void assignPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void assignIssuedLottoTickets(List<List<Integer>> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int getLottoTicketsQuantity() {
        return purchaseAmount / Amount.THOUSAND.getValue();
    }

    public List<List<Integer>> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }
}
