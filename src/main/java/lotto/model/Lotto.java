package lotto.model;

import lotto.util.RandomNumber;

import java.util.List;

import static lotto.util.HandleException.hasDuplicate;

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

        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 숫자가 포함됩니다: " + numbers);
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다: " + numbers);
            }
        }
    }

    public static List<Integer> createLotto() {
        List<Integer> lottoNumbers = RandomNumber.getRandomNumber();
        Lotto lotto = new Lotto(lottoNumbers);
        return lotto.numbers;
    }
}
