package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Enum.LottoRange;
import lotto.Messages.ErrorMessages;

public class LottoNumber {
    public List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoRange.LOTTO_LOWEST_NUMBER.getValue(),
                LottoRange.LOTTO_HIGHEST_NUMBER.getValue() - 1,
                6
        );
        validateNumbers(numbers);  // 생성된 번호 검증
        numbers.sort(Integer::compareTo);
        return numbers;
    }
    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_SIZE.message);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_RANGE.message);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessages.NUMBERS_DUPLICATE.message);
        }
    }
}



