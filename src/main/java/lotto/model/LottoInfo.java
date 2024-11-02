package lotto.model;

import java.util.List;

public class LottoInfo {
    private final List<Integer> lottoNumbers;
    private final int bonusNumber;
    private final int amounts;


    public LottoInfo(List<Integer> lottoNumbers, int bonusNumber, int amounts) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        this.amounts = amounts;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getAmounts() {
        return amounts;
    }
}
