package lotto.Model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winNumbers;
    private final int bonus;

    public WinningLotto(List<Integer> winNumbers, int bonus){
        this.winNumbers = winNumbers;
        this.bonus = bonus;
    }
}

