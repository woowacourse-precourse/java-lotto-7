package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Lottos lottos;
    private final List<Integer> winningNumbers;

    private final Integer bonusNumber;

    public Game(Lottos lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
        sortNumbers();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void sortNumbers() {
        Collections.sort(winningNumbers);
    }

}
