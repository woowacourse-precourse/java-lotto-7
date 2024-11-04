package lotto.domain.model;

import java.util.List;

public class WinningLotto {

    private final LottoNumbers winningNumbers;
    private final int bonusNumber;

    public WinningLotto(LottoNumbers winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers.getNumbers(), bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank calculateRank(LottoNumbers userLottoNumbers) {
        long matchCount = userLottoNumbers.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();

        boolean bonusMatch = userLottoNumbers.getNumbers().contains(bonusNumber);

        return LottoRank.valueOf((int) matchCount, bonusMatch);
    }
}