package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator {
    public static List<Integer> create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validateUniqueNumbers(numbers);
        return numbers;
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }
}
