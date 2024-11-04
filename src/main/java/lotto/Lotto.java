package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Optional<EnumLottoPrice> findMatch(List<Integer> numbers, Integer bonus) {
        int count = 0;
        for (int number : numbers) {
            if (this.numbers.contains(number)) {
                count++;
            }
        }
        boolean isBonusInLotto = containsBonus(bonus);
        if ((count == 2 && isBonusInLotto) || count == 3)
            return Optional.of(EnumLottoPrice.MATCH_3);
        if ((count == 3 && isBonusInLotto) || count == 4)
            return Optional.of(EnumLottoPrice.MATCH_4);
        if ((count == 4 && isBonusInLotto) || count == 5)
            return Optional.of(EnumLottoPrice.MATCH_5);
        if (count == 5 && !isBonusInLotto)
            return Optional.ofNullable(EnumLottoPrice.MATCH_5_EXCEPT_BONUS);
        if ((count == 5 && isBonusInLotto) || count == 6)
            return Optional.of(EnumLottoPrice.MATCH_6);

        return Optional.empty();
    }

    private boolean containsBonus(int bonus) {
        return this.numbers.contains(bonus);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }
}
