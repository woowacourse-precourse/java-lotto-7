package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.view.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = makeRandomNumbers();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DEFAULT_LOTTO_SIZE.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConfig.MIN_NUMBER.getNumber() || number > LottoConfig.MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getMessage());
            }
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }


    private List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_NUMBER.getNumber(),
                LottoConfig.MAX_NUMBER.getNumber(), LottoConfig.SIZE.getNumber());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
