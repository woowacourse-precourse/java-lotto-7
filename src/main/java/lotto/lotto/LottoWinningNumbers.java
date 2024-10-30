package lotto.lotto;

import java.util.List;

public class LottoWinningNumbers {
    public LottoWinningNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
