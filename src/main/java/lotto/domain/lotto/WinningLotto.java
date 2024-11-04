package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Number;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class WinningLotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public WinningLotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = createLotto(numbers);
    }

    public boolean isBonusNumber(List<Number> lotto) {
        return lotto.contains(numbers.getLast());
    }

    public void addBonusNumber(Number bonusNumbers) {
        validateBonusNumberDuplicate(bonusNumbers);
        numbers.add(bonusNumbers);
    }

    public List<Number> displayLotto() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Number> createLotto(List<Integer> numbers) {
        List<Number> lottoNumbers = new ArrayList<>();

        for (int number : numbers) {
            lottoNumbers.add(Number.from(number));
        }

        return lottoNumbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER);
        }
    }

    private void validateBonusNumberDuplicate(Number bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
