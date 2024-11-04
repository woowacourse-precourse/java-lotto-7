package lotto.model;

import lotto.dto.MatchInfo;

import java.util.*;

import static lotto.Exception.ExceptionMessage.*;

public class Lotto {
    private static final String LOTTO_NUMBER_DELIMITER_COMMA = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> parsingLottoNumbers = parseLottoNumbers(numbers);
        validate(parsingLottoNumbers);

        this.numbers = parsingLottoNumbers;
    }

    public MatchInfo calculateMatchInfo(Lotto userLotto, int bonusNumber) {
        long matchCount = userLotto.numbers.stream()
                .filter(this.numbers::contains)
                .count();

        boolean isMatchBonusNumber = this.numbers.contains(bonusNumber);

        return new MatchInfo(matchCount, isMatchBonusNumber);
    }

    public String getLottoNumbers() {
        return formatLottoNumber() + "\n";
    }

    public void checkBonusNumberDuple(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private List<Integer> parseLottoNumbers(String rawLottoNumbers) {
        try {
            return Arrays.stream(rawLottoNumbers.split(LOTTO_NUMBER_DELIMITER_COMMA))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private String formatLottoNumber() {
        return String.join(LOTTO_NUMBER_DELIMITER_COMMA + " ", Arrays.toString(sortLottoNumbers().toArray()));
    }

    private List<Integer> sortLottoNumbers() {
        return numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.VALID_LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }

        checkNumberDuple(numbers);
        checkValidArrange(numbers);
    }

    private void checkValidArrange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(
                        number ->
                                number < LottoConstant.MIN_LOTTO_NUMBER.getValue()
                                ||
                                number > LottoConstant.MAX_VALID_LOTTO_NUMBER.getValue())
        ) {
            throw new IllegalArgumentException(INVALID_RANGE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkNumberDuple(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }
}
