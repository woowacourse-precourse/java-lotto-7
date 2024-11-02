package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> lottoWinningNumbers;
    public int bonusNumber;

    public LottoWinningNumbers(List<Integer> lottoWinningNumbers, int bonusNumber) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

    //validate
}
