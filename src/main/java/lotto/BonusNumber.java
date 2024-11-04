package lotto;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> enterLottoNumbers) {
        validateBonusNumber(bonusNumber, enterLottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> enterLottoNumbers) {
        boolean containNumber = enterLottoNumbers.contains(bonusNumber);
        if (containNumber) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 숫자입니다");
        }
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1 이상, 45 이하입니다.");
        }
    }
}
