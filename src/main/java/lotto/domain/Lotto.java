package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.utils.ValidatorFactory;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidatorFactory.createUniqueNumberValidator("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.").validate(numbers);

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        numbers.forEach(number ->
                ValidatorFactory.createNumberRangeValidator(MIN_NUMBER, MAX_NUMBER, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                        .validate(number)
        );

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Rank match(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = (int) numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();

        boolean matchBonus = numbers.contains(bonusNumber.getNumber());
        return Rank.valueOf(matchCount, matchBonus);
    }
}
