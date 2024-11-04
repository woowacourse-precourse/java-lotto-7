package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = (int) userLotto.getNumbers().stream()
                .filter(winningLotto::isContainingNumber)
                .count();

        boolean matchBonus = userLotto.isContainingNumber(bonusNumber);

        return Rank.valueOf(matchCount, matchBonus);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
