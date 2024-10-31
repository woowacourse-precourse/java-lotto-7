package lotto.model;

import java.util.List;

public class LottoResults {
    public int calculateResult(List<Integer> winningNumbers, List<Integer> userNumbers) {
        return (int) winningNumbers.stream().filter(userNumbers::contains).count();
    }
}
