package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;

    private WinningLotto(List<Integer> numbers){
        this.numbers=numbers;
    }

    public static WinningLotto of(List<Integer> numbers){
        return new WinningLotto(numbers);
    }

    public boolean isContains(int number){
        return numbers.contains(number);
    }
}
