package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;


    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
