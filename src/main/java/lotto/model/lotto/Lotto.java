package lotto.model.lotto;

import lotto.error.LottoErrorMessage;
import lotto.model.Winning;
import lotto.model.lotto.constant.LottoNumberPrintFormat;
import lotto.model.lotto_result.DrawNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final long PRICE = 1000;
    public static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers; // numbers 이외의 필드(인스턴스 변수) 추가 불가능, private 변경 불가능

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_NUMBERS_COUNT.getMessage());
        }

        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    public String numbersToString() {
        return LottoNumberPrintFormat.PREFIX + getJoinedNumbers() + LottoNumberPrintFormat.SUFFIX;
    }

    private String getJoinedNumbers() {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        return sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoNumberPrintFormat.DELIMITER));
    }

    public Winning checkWinner(DrawNumbers drawNumbers) {
        int matchCount = drawNumbers.countMatch(numbers);
        boolean isMatchBonusNumber = drawNumbers.isMatchBonusNumber(numbers);

        return Winning.getPlaceByMatch(matchCount, isMatchBonusNumber);
    }
}
