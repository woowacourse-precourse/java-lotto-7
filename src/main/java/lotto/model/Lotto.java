package lotto.model;

import java.util.List;
import lotto.util.LottoInfo;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateUnique(numbers);
        this.numbers = numbers;
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoInfo.NUMBER_COUNT.getNum()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + LottoInfo.NUMBER_COUNT.getNum() + "개여야 합니다.");
        }
    }

    private static void validateUnique(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
