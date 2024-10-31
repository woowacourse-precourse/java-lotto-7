package model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = LottoGenerator.generateLotto();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
