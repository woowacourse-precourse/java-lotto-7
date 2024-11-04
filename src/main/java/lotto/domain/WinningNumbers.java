package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumbers;

    private WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<Integer> numbers){
        Lotto lotto = new Lotto(numbers);
        return new WinningNumbers(lotto);
    }
}
