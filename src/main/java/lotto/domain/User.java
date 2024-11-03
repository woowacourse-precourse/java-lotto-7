package lotto.domain;

import static lotto.util.GenerateLottoNumbers.generateLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class User {
    private PurchaseAmount purchaseAmount;
    private List<UserLotto> lottoTickets;
    private int winningPrice;

    private User() {
    }

    public User(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTickets = new ArrayList<>();
        this.winningPrice = 0;
    }

    public void createLottoTickets() {
        this.lottoTickets = generateLottoNumbers(purchaseAmount.getTicketQuantity());
    }

    public void addWinningPrice(int money) {
        this.winningPrice += money;
    }

    public int getQuantityTickets() {
        return purchaseAmount.getTicketQuantity();
    }

    public List<UserLotto> getLottoTickets() {
        return lottoTickets;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getAmount();
    }
}
