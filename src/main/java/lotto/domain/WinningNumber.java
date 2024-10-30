package lotto.domain;

import java.util.List;

public class WinningNumber {
    private Lotto numbers;
    private int bonus;

    public WinningNumber(Lotto numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }
}
