package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    protected static final int LOTTO_NUMBER_MIN = 1;
    protected static final int LOTTO_NUMBER_MAX = 45;
    protected static final int LOTTO_SIZE = 6;
    protected static final String ERROR_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    protected static final String ERROR_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    protected static final String ERROR_DUPLICATE_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    protected static final String ERROR_NUMBER_FORMAT_MESSAGE = "[ERROR] 로또 번호는 숫자여야 합니다.";

    private final List<Integer> numbers;

    public Lotto() throws IllegalArgumentException {
        List<Integer> numbers = generate();
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
        System.out.println(this.numbers);
    }

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateOnlyInteger(numbers);
        validateRange(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);
        if (hasInvalidNumber) {
            throw new IllegalArgumentException(ERROR_RANGE_MESSAGE);
        }
    }

    private static void validateOnlyInteger(List<Integer> numbers) {
        boolean hasNonNumeric = numbers.stream().anyMatch(number -> !(number instanceof Integer));
        if (hasNonNumeric) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateDuplicated(List<Integer> numbers) {
        if (numbers.size() != new HashSet<Integer>(numbers).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MESSAGE);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
        }
    }

    private List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }


}
