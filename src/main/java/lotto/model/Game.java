package lotto.model;

import java.util.List;

public class Game {
    Lottos lottos;
    List<Integer> winningNumbers;
    Integer bonusNumber;

    public Game(Lottos lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
