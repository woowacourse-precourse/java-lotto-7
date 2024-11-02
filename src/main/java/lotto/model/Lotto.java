package lotto.model;

import java.util.List;

/*
로또 당첨번호
*/
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

}
