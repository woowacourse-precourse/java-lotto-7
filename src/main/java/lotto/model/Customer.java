package lotto.model;

public class Customer {

    private int lottoTickets = 0;

    public void buyLottoTickets(int money) {
        lottoTickets += money / 1000;
    }

    public int getLottoTickets() {
        return lottoTickets;
    }

}
