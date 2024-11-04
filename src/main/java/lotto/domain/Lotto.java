package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final Integer LOTTO_NUMBERS_SIZE = 6;
    protected static final Integer lowerBound = 1;
    protected static final Integer upperBound = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = AscNumberList(numbers);
    }

    private static List<Integer> AscNumberList(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    protected static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    protected static void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != getDistinctSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static int getDistinctSize(List<Integer> numbers) {
        return numbers.stream().distinct().toList().size();
    }

    protected static void validateRange(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (num < lowerBound || num > upperBound) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 숫자만 가능합니다.");
            }
        });
    }

    protected void containBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 로또 번호가 로또 번호와 중복되면 안 됩니다");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
