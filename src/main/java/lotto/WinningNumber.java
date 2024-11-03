package lotto;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final Integer bonus;

    public WinningNumber(List<Integer> numbers, Integer bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer getBonus(){
        return this.bonus;
    }
}