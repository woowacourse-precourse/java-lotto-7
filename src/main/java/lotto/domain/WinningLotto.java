package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber){
        return new WinningLotto(numbers,bonusNumber);
    }



}
