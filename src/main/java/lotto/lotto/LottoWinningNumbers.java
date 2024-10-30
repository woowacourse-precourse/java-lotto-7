package lotto.lotto;

import java.util.List;

public class LottoWinningNumbers {
    private static final String DUPLICATE_BONUS_ERROR_MESSAGE = "[ERROR] 보너스 번호에 중복이 있습니다.";
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.winningNumbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }
}