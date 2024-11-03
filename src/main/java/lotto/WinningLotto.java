package lotto;

import java.util.List;
import java.util.Optional;

public class WinningLotto {
    private final List<Integer> numbers;
    private Optional<Integer> bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        this(numbers, Optional.empty());
    }

    public WinningLotto(List<Integer> numbers, Optional<Integer> bonusNumber) {
        validateNumbers(numbers);
        this.numbers = numbers;
        bonusNumber.ifPresent(this::validateWinningNumbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s", numbers.toString(), bonusNumber.map(String::valueOf).orElse(""));
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateWinningNumbers(bonusNumber);
        this.bonusNumber = Optional.of(bonusNumber);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        if (numbers.stream().distinct().count() != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        numbers.forEach(number -> {
            if (number < 1 || number > 45) throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
        });
    }

    private void validateWinningNumbers(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        if (numbers.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    public LottoResult match(Lotto lotto) {
        int bonusNumber = this.bonusNumber.orElseThrow(() -> new IllegalStateException("[ERROR] 보너스 번호가 입력되지 않았습니다."));
        int matchCount = lotto.getNumbers().stream()
                .filter(numbers::contains)
                .toList()
                .size();
        boolean isMatchBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoResult.of(matchCount, isMatchBonus);
    }
}
