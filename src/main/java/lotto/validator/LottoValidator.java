package lotto.validator;

import java.util.List;

public class LottoValidator {

    public void validateLottoRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 잘못된 번호: " + number);
            }
        }
    }
}
