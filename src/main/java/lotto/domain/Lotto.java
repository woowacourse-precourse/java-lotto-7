package lotto.domain;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstants.INPUT_IS_NOT_NUMBER;
import static lotto.domain.LottoConstants.IS_DUPLICATE_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_SIZE;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = makeSortLotto(numbers);
    }

    public Lotto(Integer... lottoNumbers) {
        this(Arrays.stream(lottoNumbers).collect(toList()));
    }

    public Lotto(String[] inputNumbers) {
        this(splitInput(inputNumbers));
    }

    private static List<Integer> splitInput(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(convertStringToInt(number));
        }
        return numbers;
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    private void validateLotto(List<Integer> numbers) {
        validateLottoSetSize(numbers);
        valdiateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private void validateLottoSetSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LottoConstants.LOTTO_MIN_NUM || number > LottoConstants.LOTTO_MAX_NUM) {
                throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
            }
        }
    }

    private List<Integer> makeSortLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isNumberContain(int number) {
        return numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
