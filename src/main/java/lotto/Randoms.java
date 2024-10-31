package lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Randoms {
    private static final Random random = new Random();

    public static Set<Integer> pickUniqueNumbersInRange(int min, int max, int count) {
        if (count > (max - min + 1)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 있는 숫자의 개수가 범위를 초과합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < count) {
            int number = random.nextInt(max - min + 1) + min;
            uniqueNumbers.add(number);
        }

        return uniqueNumbers;
    }
}
