package lotto.domain;

public class LottoShop {
    private final LottoTickets lottoTickets;

    public LottoShop(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public static LottoShop buyLotteries(LottoCount lottoCount) {
        long purchasedLotteriesCount = lottoCount.getCount();
        LottoTickets lottoTickets = LottoTickets.generateLottoTickets(purchasedLotteriesCount);
        return new LottoShop(lottoTickets);
    }
}
