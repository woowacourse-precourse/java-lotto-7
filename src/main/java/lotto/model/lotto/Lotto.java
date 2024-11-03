package lotto.model.lotto;

import lotto.error.LottoErrorMessage;
import lotto.model.Winning;
import lotto.model.lotto_result.DrawNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers; // numbers 이외의 필드(인스턴스 변수) 추가 불가능, private 변경 불가능

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoPrintFormat.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
        }

        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    public String numbersToString() {
        return LottoPrintFormat.PREFIX + getJoinedNumbers() + LottoPrintFormat.SUFFIX;
    }

    private String getJoinedNumbers() {
        numbers.sort(Integer::compareTo);
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoPrintFormat.DELIMITER));
    }

    public Winning checkWinner(DrawNumbers drawNumbers) {
        int matchCount = drawNumbers.countMatch(numbers);
        int countBonusNumber = drawNumbers.countBonusNumber(numbers);

        return Winning.getPlace(matchCount, countBonusNumber);
    }
    // TODO: 추가 기능 구현
}
