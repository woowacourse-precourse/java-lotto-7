package lotto.model;

import java.util.List;

public class Game {
    Lottos lottos;
    List<Integer> winningNumbers;

    public Game(Lottos lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }
}
