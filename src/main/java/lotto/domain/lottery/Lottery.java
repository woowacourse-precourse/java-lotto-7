package lotto.domain;

import java.util.List;

public interface Lottery {
    List<Integer> getNumbers();

    Integer countMatchingWinningNumbers(List<Integer> winningNumbers);
}
