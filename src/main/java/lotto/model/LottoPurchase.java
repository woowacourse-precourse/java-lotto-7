package lotto.model;

public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private final LottoTickets lottoTickets;
    private final int money;

    public LottoPurchase(int money) {
        this.lottoTickets = new LottoTickets(money / LOTTO_PRICE);
        this.money = money;
    }

    public LottoPurchaseResult getLottoPurchaseResult() {
        return new LottoPurchaseResult(lottoTickets.getLottoTicketsNumbers(), money / LOTTO_PRICE);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public int getMoney() {
        return money;
    }
}
