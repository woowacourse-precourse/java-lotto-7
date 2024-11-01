package lotto.domain;

import java.util.List;
import lotto.util.ParseUtil;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto createLotto(String input) {
        List<Integer> numbers = ParseUtil.parseToList(input);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
