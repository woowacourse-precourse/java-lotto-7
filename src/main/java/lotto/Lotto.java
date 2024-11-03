package lotto;

import static exception.Exception.DUPLICATE_NUMBER;
import static exception.Exception.ERROR_PREFIX;
import static exception.Exception.LOTTO_LENGTH_ONLY_SIX;
import static exception.Exception.ONLY_ONE_TO_FORTY_FIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_PRICE = 1000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLotto(numbers);
    }

    private void throwException(String message) {
        throw new IllegalArgumentException(ERROR_PREFIX + message);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throwException(LOTTO_LENGTH_ONLY_SIX);
        }
        validateLottoNumber(numbers);
        if (checkExistDuplNumber(numbers)) {
            throwException(DUPLICATE_NUMBER);
        }
    }

    private List<Integer> sortLotto(List<Integer> beforeSortNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(beforeSortNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public void validateLottoNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throwException(ONLY_ONE_TO_FORTY_FIVE);
            }
        }
    }

    public boolean checkExistDuplNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public int findDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> myNumbers = new HashSet<>(numbers);
        Set<Integer> compareNumbers = new HashSet<>(lottoNumbers);
        myNumbers.retainAll(compareNumbers);
        return myNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
