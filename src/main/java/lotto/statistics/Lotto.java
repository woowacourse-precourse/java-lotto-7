package lotto.statistics;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumber(numbers);
        checkLottoRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatches(List<Integer> myLotto) {
        List<Integer> matchedCount = new ArrayList<>(numbers);
        matchedCount.retainAll(myLotto);
        return matchedCount.size();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private void checkLottoRange(List<Integer> numbers) {
        for (Integer rawNumber : numbers) {
            if (!LottoBall.isInRange(rawNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45만 가능합니다.");
            }
        }
    }
}
