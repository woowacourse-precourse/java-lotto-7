package lotto.domain;

import java.util.List;

import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        validateRange(bonusNumber);
        validateNumber(bonusNumber, lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumber(int number, List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 있으면 안됩니다.");
        }
    }


    public int getBonusNumber() {
        return bonusNumber;
    }
}
