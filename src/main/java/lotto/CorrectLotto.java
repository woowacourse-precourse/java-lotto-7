package lotto;

import lotto.view.LottoInput;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                                throw new IllegalArgumentException("[ERROR] 당첨번호는 1~45의 정수이어야 합니다.");
                            }
                        })
                .toList();
        validateDuplicates(numbers);
        return new Lotto(numbers);
    }

    public static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 중복될 수 없습니다.");
        }
    }


    public Rank match(Lotto other) {
        int matchCount = (int) lotto.numbers().stream()
                .filter(other.numbers()::contains)
                .count();
        boolean isContainBonusNumber = other.numbers().contains(bonusNumber.number());

        return Rank.of(matchCount, isContainBonusNumber);
    }
}
