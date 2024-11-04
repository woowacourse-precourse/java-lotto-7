package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.info.LottoInfo;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = makeRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.MIN_NUMBER.getNumber(), LottoInfo.MAX_NUMBER.getNumber(),
                LottoInfo.COUNT.getNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
