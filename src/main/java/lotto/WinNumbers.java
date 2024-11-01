package lotto;

import java.util.List;
import lotto.Lotto;

public class WinNumbers {

    private List<Integer> WinNumbers;
    private int bonusNumber;

    public WinNumbers(List<Integer> winNumbers, int bonusNumber) {
        Lotto.validate(winNumbers);
        validate(winNumbers, bonusNumber);
        this.WinNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validate(List<Integer> winNumbers, int bonusNumber) {
        if (1 > bonusNumber || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호는 1이상 45이하의 숫자만 가능합니다.");
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 로또 번호는 중복될 수 없습니다.");
        }
    }
}
