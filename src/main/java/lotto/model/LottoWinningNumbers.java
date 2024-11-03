package lotto.model;

import java.util.Collections;
import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    // 생성자를 통해 당첨 번호와 보너스 번호를 설정
    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
