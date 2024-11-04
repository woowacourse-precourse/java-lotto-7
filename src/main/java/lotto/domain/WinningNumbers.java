package lotto.domain;

import static lotto.domain.Lotto.MIN_LOTTO_NUMBER;
import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.SIZE_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ErrorMessage;

public class WinningNumbers {
    private final List<Integer> receivedLottoNumbers;

    public WinningNumbers(List<Integer> receivedLottoNumbers) {
        validateLottoNumbers(receivedLottoNumbers);
        this.receivedLottoNumbers = receivedLottoNumbers;
    }

    private void validateLottoNumbers(List<Integer> receivedLottoNumbers) {
        checkSize(receivedLottoNumbers);
        checkRange(receivedLottoNumbers);
        checkDuplicate(receivedLottoNumbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != SIZE_OF_LOTTO) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getReceivedLottoNumbers() { // 결과 계산에 호출됨
        return receivedLottoNumbers;
    }
}
