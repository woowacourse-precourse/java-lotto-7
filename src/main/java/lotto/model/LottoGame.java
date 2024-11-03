package lotto.model;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final LottoDrawResult lottoDrawResult;
    private final int money;

    public LottoGame(LottoTickets lottoTickets, LottoDrawResult lottoDrawResult, int money) {
        this.lottoTickets = lottoTickets;
        this.lottoDrawResult = lottoDrawResult;
        this.money = money;
    }
}
