package lotto.model;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;
    private final int money;

    public LottoGame(LottoTickets lottoTickets, WinningLotto winningLotto, int money) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = winningLotto;
        this.money = money;
    }
}
