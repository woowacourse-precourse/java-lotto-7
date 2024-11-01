package lotto.random;

import java.util.List;

public interface Random {

    int START_INCLUSIVE = 1;
    int END_INCLUSIVE = 45;
    int NUMBER_COUNT = 6;

    List<Integer> pickUniqueNumbersInRange();
}
