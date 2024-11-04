package lotto.model;

import lotto.util.ErrorMessage;
import lotto.util.Limit;
import lotto.util.Message;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // LottoTest를 수정하지 않기 위해 접근지정자 유지
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createUserLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto createWinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
        validateRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Limit.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.LOTTO_NUMBER_COUNT.getError());
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.UNIQUE_LOTTO_NUMBER.getError());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(integer ->
                integer < Limit.MIN_LOTTO_NUMBER.getValue() || integer > Limit.MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(Message.ERROR_TAG.getSentence()
                    + ErrorMessage.LOTTO_NUMBER_RANGE.getError());
        }
    }
}
