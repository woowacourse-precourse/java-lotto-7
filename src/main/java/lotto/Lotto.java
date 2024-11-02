package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkIsUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkIsUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

    public static void printLotto(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.numbers);
        Collections.sort(sortedNumbers);

        System.out.println(sortedNumbers);
    }

    public static PointResult compareLotto(Lotto winningLotto, Integer bonusNumber, Lotto purchasedLotto) {
        int point = 0;
        int bonusPoint = 0;

        for (Integer number : purchasedLotto.numbers) {
            if (winningLotto.numbers.contains(number)) {
                point += 1;
            }
            if (number.equals(bonusNumber)) {
                bonusPoint = 1;
            }
        }

        if (point != 5) {
            bonusPoint = 0;
        }

        PointResult pointResult = new PointResult(point, bonusPoint);
        return pointResult;
    }
}
