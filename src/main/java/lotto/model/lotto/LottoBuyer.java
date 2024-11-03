package lotto.model.lotto;

public class LottoBuyer {
    private int ownedTickets;

    public void buyTickets(int budget, LottoStore store) {
        this.ownedTickets = store.calculateTicketsCount(budget);
    }

    public int getOwnedTickets() {
        return ownedTickets;
    }
}