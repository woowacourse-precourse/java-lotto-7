package lotto.model.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
// 로또 번호에 대한 검증 진행 후 로또를 생성한다.
// Integer를 Number라는 객체로 포장해서 Lotto와 Number의 책임을 분리하는 것도 좋은 방법이라고 생각된다.
// 미션에서는 제공받은 클래스를 사용하라는 문구가 있기 때문에 큰 변화를 주지 않고 구현했지만 추후 리펙토링 대상에 추가
public class Lotto {

    private static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String INVALID_DUPLICATION_MASSAGE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    private static final String INVALID_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private static final String DISPLAY_LOTTO_HEADER = "[";
    private static final String DISPLAY_LOTTO_FOOTER = "]";
    private static final String DISPLAY_LOTTO_DELIMITER = ", ";

    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicationNumber(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION_MASSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if ( number < MIN_NUMBER || number > MAX_NUMBER ) {
                throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
            }
        });
    }
    // 로또가 넘버를 가지고 있는지에 대한 메세지를 받을 수 있다!
    public boolean isContain(int number) {
        return numbers.contains(number);
    }
    // 로또가 다른 로또와 몇개나 일치하는 지 갯수를 알 수 있다!!
    public int countSameNumber(Lotto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            if(lotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return DISPLAY_LOTTO_HEADER +
                numbers.stream()
                        .sorted()
                        .map(Object::toString)
                        .collect(
                                Collectors.joining(DISPLAY_LOTTO_DELIMITER)
                        )
                + DISPLAY_LOTTO_FOOTER;
    }

}
