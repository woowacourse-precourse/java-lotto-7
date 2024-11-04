package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setWinningNumbers(List<Integer> numbers, Integer bonus) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonus;
    }
}