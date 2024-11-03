package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.model.exception.DomainExceptionMessage;

public class AnswerNumbers {
    private static final String seperator = ",";
    private static final int ANSWER_SIZE = 6;

    private final List<LottoNumber> answerNumbers;

    public AnswerNumbers(List<LottoNumber> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public List<LottoNumber> getAnswerNumbers() {
        return List.copyOf(answerNumbers);
    }

    public static AnswerNumbers from(String input) {
        List<LottoNumber> answers = Arrays.stream(input.split(seperator))
                .map(LottoNumber::new)
                .toList();
        validate(answers);
        return new AnswerNumbers(answers);
    }

    private static void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != ANSWER_SIZE) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.INVALID_ANSWER_SIZE.getMessage()
            );
        }
    }

    private static void validateDuplication(List<LottoNumber> numbers) {
        long distinctNumberCount = numbers.stream().distinct().count();
        if (distinctNumberCount != numbers.size()) {
            throw new IllegalArgumentException(
                    DomainExceptionMessage.DUPLICATED_ANSWER_NUMBER.getMessage()
            );
        }
    }
}
