package lotto.domain.lottery;

import java.util.List;

public interface Lottery {
    List<Integer> getNumbers();
    Integer countMatchingWinningNumbers(List<Integer> winningNumbers);

    boolean contains(int bonusNumber);
}
