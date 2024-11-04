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

        for (int number : numbers) {
            if (number < LottoRules.MIN_NUMBER || number > LottoRules.MAX_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(lotto.ErrorMessage.OUT_OF_BOUNDS.getMessage(), LottoRules.MIN_NUMBER,
                                LottoRules.MAX_NUMBER));
            }
        }

        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(lotto.ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}