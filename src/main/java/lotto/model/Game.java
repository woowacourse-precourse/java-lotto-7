package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final WinningCount winningCount = new WinningCount();
    private final List<Integer> winningAmount = new ArrayList<>(List.of(0, 5, 50, 1500, 30000, 2000000));

    public Game(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public WinningCount getWinningCount() {
        return winningCount;
    }

    public List<Integer> getWinningAmount() {
        return winningAmount;
    }
}
