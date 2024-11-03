package lotto;

import lotto.constant.Amount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchaseDetails {

    private int purchaseAmount;
    private List<List<Integer>> lottoTicketList = new ArrayList<>();

    public void assignPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void assignIssuedLottoTickets(List<List<Integer>> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public int getLottoTicketsQuantity() {
        return purchaseAmount / Amount.THOUSAND.getValue();
    }

    public List<List<Integer>> getLottoTicketList() {
        return Collections.unmodifiableList(this.lottoTicketList);
    }
}
