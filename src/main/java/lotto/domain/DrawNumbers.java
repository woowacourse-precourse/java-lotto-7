package lotto.domain;

import java.util.List;

public class DrawNumbers {
    private List<Integer> lottoNumbers;
    private int bonusNumber;

    public DrawNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
