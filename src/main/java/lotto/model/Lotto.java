package lotto.model;

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

    public WinningType match(AnswerNumbers answer, BonusNumber bonusNumber) {
        int matchCount = match(answer);
        boolean matchBonus = matchBonus(bonusNumber);
        return WinningType.of(matchCount, matchBonus);
    }

    private int match(AnswerNumbers answer) {
        return (int)answer.getAnswerNumbers().stream()
                .map(LottoNumber::getNumber)
                .filter(numbers::contains)
                .count();
    }

    private boolean matchBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

}
