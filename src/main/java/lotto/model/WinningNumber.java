package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private List<Lotto> lottos = new ArrayList<>();

    public WinningNumber(String winningNumbers) {
        List<Integer> winningNumber = parseWinningNumbers(winningNumbers);
        lottos.add(new Lotto(winningNumber));
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
