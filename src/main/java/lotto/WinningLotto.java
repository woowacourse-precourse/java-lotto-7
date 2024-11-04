package lotto;

import java.util.List;

public class WinningLotto {
    private final WinningLottoNumbers winningNumbers;
    private final lotto.BonusNumber bonusNumber;

    public WinningLotto(List<String> winningNumbers, List<String> bonusNumbers) {
        this.winningNumbers = new WinningLottoNumbers(winningNumbers);
        this.bonusNumber = new lotto.BonusNumber(bonusNumbers, winningNumbers);
    }

    public WinningLottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public lotto.BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
