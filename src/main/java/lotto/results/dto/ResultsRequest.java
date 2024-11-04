package lotto.results.dto;

import lotto.checker.domain.BonusNumber;
import lotto.checker.domain.Lottos;
import lotto.checker.domain.WinningNumbers;

public class ResultsRequest {

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public ResultsRequest(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lottos getLottos() { return lottos; }
    public WinningNumbers getWinningNumbers() { return winningNumbers; }
    public BonusNumber getBonusNumber() { return bonusNumber; }
}
