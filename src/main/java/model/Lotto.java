package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = LottoGenerator.generateLotto();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

}
