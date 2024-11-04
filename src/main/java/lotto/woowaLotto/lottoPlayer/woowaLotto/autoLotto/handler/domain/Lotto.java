package lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validCount(numbers);
        validRange(numbers);
        validDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validCount(List<Integer> parsedList) {
        if (parsedList.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validRange(List<Integer> parsedList) {
        for (Integer num : parsedList) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validDuplicate(List<Integer> parsedList) {
        Set<Integer> uniqueNumbers = new HashSet<>(parsedList);
        if (parsedList.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
