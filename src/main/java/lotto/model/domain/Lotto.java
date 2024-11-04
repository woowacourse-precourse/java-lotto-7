package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoConfig;
import lotto.util.ValidatorErrorMessage;

public class Lotto {
    private final static String PREFIX = "[";
    private final static String SUFFIX = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_COUNT_NUMBER) {
            throw new IllegalArgumentException(ValidatorErrorMessage.NUMBER_COUNT_EXCEPTION.getErrorMessage());
        }
    }

    public int countMatch(List<Integer> winningNumbers) {
        int count = LottoConfig.ZERO;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }

    public String toFormattedString() {
        String lottoNumber = PREFIX + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) + SUFFIX;
        return lottoNumber;
    }

    public int getResult(WinningNumbers winningNumbers) {
        int match = winningNumbers.countMatch(numbers);
        if (match < WinningMatch.valueOfMinMatch().getMatch()) {
            return WinningMatch.valueOfMinMatch().getRank() + 1;
        }
        int rank = WinningMatch.valueOfMatch(match).getRank();
        if (rank == WinningMatch.THIRD.getRank()) {
            return WinningMatch.SECOND.getRank();
        }
        return rank;
    }
}
