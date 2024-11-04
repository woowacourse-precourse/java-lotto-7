package lotto;

import lotto.view.LottoInput;

import java.util.List;

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
        return new Lotto(numbers);
    }

    private void validateDuplicate(Lotto lotto, int bonusNumber) {
        if(lotto.numbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 정답 번호는 중복될 수 없습니다.");
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
