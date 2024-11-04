package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final static int NUMBERS_LENGTH = 6;
    private final static String LENGTH_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    private final static String NO_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복되면 안됩니다.";
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public Lotto(Integer... numbers) {
        this(List.of(numbers));
    }

    public static Lotto createRandomized() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.RANGE_MINIMUM, LottoNumber.RANGE_MAXIMUM,
                NUMBERS_LENGTH));
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public int countMatchesWith(Lotto other) {
        return Math.toIntExact(numbers.stream()
                .filter(other::contains)
                .count());
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }
}
