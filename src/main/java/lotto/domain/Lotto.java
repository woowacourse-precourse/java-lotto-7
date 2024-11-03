package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import lotto.util.LottoConstant;
import lotto.util.LottoError;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.THE_NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoError.NUMBER_COUNT_ERROR.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(LottoError.NUMBER_DUPLICATED_ERROR.getMessage());
        }
    }

    public List<Integer> sortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


    public int countWinningNumbers(List<Integer> winningNumbers) {
        int countWin = 0;

        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                countWin++;
            }
        }
        return countWin;
    }

    public int checkRank(int countWin, int bonusNumber) {
        if (countWin == LottoConstant.THE_NUMBER_OF_LOTTO_NUMBER) {
            return 1;
        }
        if (countWin == 5 && numbers.contains(bonusNumber)) {
            return 2;
        }
        if (countWin == 5 && !numbers.contains(bonusNumber)) {
            return 3;
        }
        if (countWin == 4) {
            return 4;
        }
        if (countWin == 3) {
            return 5;
        }
        return 0;
    }


    @Override
    public String toString() {
        StringJoiner lottoJoiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            lottoJoiner.add(String.valueOf(number));
        }
        return lottoJoiner.toString();
    }
}
