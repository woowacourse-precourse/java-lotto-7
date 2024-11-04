package lotto;

import lotto.exception.InvalidNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.ErrorMessage.*;

public class CorrectLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public CorrectLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static Lotto createCorrectNumber(List<String> inputs) {
        List<Integer> numbers = inputs.stream()
                .map(
                        input -> {
                            try {
                                return Integer.parseInt(input);
                            } catch (NumberFormatException e) {
                                throw new InvalidNumberException(INVALID_NUMBER_RANGE.getMessage());
                            }
                        })
                .toList();
        return new Lotto(numbers);
    }



    public Rank match(Lotto other) {
        int matchCount = (int) lotto.numbers().stream()
                .filter(other.numbers()::contains)
                .count();
        boolean isContainBonusNumber = other.numbers().contains(bonusNumber.number());

        return Rank.of(matchCount, isContainBonusNumber);
    }
}
