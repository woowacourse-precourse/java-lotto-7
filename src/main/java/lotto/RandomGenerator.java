package lotto;

import java.util.List;

public interface RandomGenerator {
    int pickNumberInRange(int start, int end);

    List<Integer> pickUniqueNumbersInRange(int start, int end, int count);
}
