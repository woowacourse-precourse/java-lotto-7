package lotto.domain;

import java.util.List;
//  - 로또 기계에서 당첨 번호를 뽑는다
//  - 로또 기계에서 보너스 번호를 뽑는다
public class LottoMachine {
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public LottoMachine(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
