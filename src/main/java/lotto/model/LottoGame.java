package lotto.model;

public class LottoGame {
    private final LottoTickets lottoTickets;
    private final LottoResult lottoResult;
    private int money;

    public LottoGame(LottoTickets lottoTickets, LottoResult lottoResult) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = lottoResult;
    }
}
