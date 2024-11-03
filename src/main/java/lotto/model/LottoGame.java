package lotto.model;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final LottoResult lottoResult;
    private final int money;

    public LottoGame(LottoTickets lottoTickets, LottoResult lottoResult, int money) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = lottoResult;
        this.money = money;
    }
}
