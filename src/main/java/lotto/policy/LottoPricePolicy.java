package lotto.policy;

public enum LottoPricePolicy {
    LOTTO_TICKET_PRICE(1_000);

    private final int lottoTicketPrice;

    LottoPricePolicy(int price) {
        this.lottoTicketPrice = price;
    }

    public int getLottoTicketPrice() {
        return lottoTicketPrice;
    }
}
