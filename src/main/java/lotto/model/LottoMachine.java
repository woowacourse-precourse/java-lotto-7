package lotto.model;

public class LottoMachine {
    private final WinningNumbers winningNumbers;
    private final LottoBundle lottoBundle;

    public LottoMachine(WinningNumbers winningNumbers, LottoBundle lottoBundle) {
        this.winningNumbers = winningNumbers;
        this.lottoBundle = lottoBundle;
    }

    public LottoBundle getLottoBundle() {
        return lottoBundle;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
