package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;
    public static final int PRICE = 1000;
    public static final String NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복 될 수 없습니다.";
    public static final String NUMBER_RANGE_EXCEPTION_MESSAGE = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", NUMBER_MIN, NUMBER_MAX);
    public static final String NUMBER_SIZE_EXCEPTION_MESSAGE = String.format("로또 번호는 %d개여야 합니다.", NUMBER_SIZE);
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sort(numbers);
    }

    static public Lotto of(String numbers) {
        return new Lotto(Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < NUMBER_MIN || number > NUMBER_MAX) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public String toString() {
        return numbers.toString();
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public int containsCount(Lotto winner) {
        int count = 0;
        for (Integer number : numbers) {
            if (winner.numbers.contains(number)) count++;
        }

        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber < NUMBER_MIN || bonusNumber > NUMBER_MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        if (numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public static Lotto getRandom() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(NUMBER_MIN, NUMBER_MAX, NUMBER_SIZE));
    }

    // TODO: 구현 기능 목록
    //  - [x] 번호의 유효성을 체크한다.
    //  - [x] 번호를 정렬한다.
    //  - [x] 우승 로또와 맞는 개수를 전달한다.
    //  - [x] 보너스볼을 체크한다.
    //  - [x] 로또 번호를 전달한다.
}
