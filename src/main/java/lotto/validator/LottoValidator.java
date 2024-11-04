package lotto.validator;

import java.util.List;

public class LottoValidator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public void validateLottoRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 정수여야 합니다. 잘못된 번호: " + number);
            }
        }
    }
}
