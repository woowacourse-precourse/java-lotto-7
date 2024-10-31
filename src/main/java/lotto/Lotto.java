package lotto;

import lotto.constant.OutputMessage;

import java.util.List;

public class Lotto {
    private static final String SCREEN_START = "[";
    private static final String SCREEN_END = "]";
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

    public String getScreen() {
        return SCREEN_START +
                String.join(OutputMessage.COMMA.getMessage(), numbers.stream().map(String::valueOf).toList()) +
                SCREEN_END;
    }
}
