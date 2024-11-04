package lotto.provider;

import java.util.List;

public interface NumberProvider {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int NUMBER_COUNT = 6;

    List<Integer> getNumbers();
}
