package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public String printNumbers() {
        String outputStirng = "";
        for (Integer e : numbers) {
            outputStirng = outputStirng + e + ", ";
        }
        outputStirng = outputStirng.substring(0, outputStirng.length() - 2);
        return '[' + outputStirng + ']';
    }
}
