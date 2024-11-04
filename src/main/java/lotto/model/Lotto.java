package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.exception.LottoExceptionStatus.*;
import static lotto.properties.LottoProperties.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        Collections.sort(lottoNumbers);
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> numbers) {
        isGeneratedSixNumbers(numbers);
        isDuplicate(numbers);
        isOutOfRange(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void isOutOfRange(List<Integer> winningLottery) {
        winningLottery.forEach(this::checkRangeEachNumber);
    }

    private void checkRangeEachNumber(Integer number) {
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException(INVALID_GENERATED_LOTTO_NUMBERS_RANGE.getMessage());
        }
    }

    private void isGeneratedSixNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_QUANTITY) {
            throw new IllegalArgumentException(INVALID_GENERATED_LOTTO_NUMBERS_SIZE.getMessage());
        }
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != LOTTO_NUMBER_QUANTITY) {
            throw new IllegalArgumentException(INVALID_GENERATED_LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START,
                LOTTO_NUMBER_END,
                LOTTO_NUMBER_QUANTITY
        );
        return new Lotto(numbers);
    }
}
