package lotto.model;

import static lotto.ErrorMessage.ERROR_DUPLICATE_MESSAGE;
import static lotto.ErrorMessage.ERROR_RANGE_MESSAGE;
import static lotto.ErrorMessage.ERROR_SIZE_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.RandomNumbersGenerator;

public class Lotto {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto(RandomNumbersGenerator numbersGenerator) throws IllegalArgumentException {
        List<Integer> generatedNumbers = numbersGenerator.generate();
        validate(generatedNumbers);
        ArrayList<Integer> mutableNumbers = new ArrayList<>(generatedNumbers);
        mutableNumbers.sort(Integer::compareTo);
        this.numbers = mutableNumbers;
    }

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        ArrayList<Integer> mutableNumbers = new ArrayList<>(numbers);
        mutableNumbers.sort(Integer::compareTo);
        this.numbers = mutableNumbers;
    }

    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    public void validate(int number) throws IllegalArgumentException {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE.getMessage());
        }
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE.getMessage());
        }
    }

    private static void validateDuplicated(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != new HashSet<Integer>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE_MESSAGE.getMessage());
        }
    }

    public String displayNumbers() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
