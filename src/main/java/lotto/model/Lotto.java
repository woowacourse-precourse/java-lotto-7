package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int SIZE = 6;

    private static final String INVALID_RANGE = "[ERROR] 로또 번호는 1-45 사이의 정수여야 합니다.";
    private static final String INVALID_NUMBER = "[ERROR] 로또 번호의 모든 숫자는 서로 다른 숫자여야 합니다.";
    private static final String INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateRange(numbers);
        validateDuplication(numbers);
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START || number > END) {
                throw new IllegalArgumentException(INVALID_RANGE);
            }
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(INVALID_NUMBER);
            }
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public static List<List<Integer>> makeRandomNumbers(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(START, END, SIZE);
            lottos.add(randomNumbers);
        }
        return lottos;
    }
}
