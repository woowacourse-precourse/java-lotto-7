package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, int bonusNumber) {
        if (lottoContainsBonusNumber(lotto, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private boolean lottoContainsBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoRank match(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        int matchCnt = 0;
        for (int winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                matchCnt++;
            }
        }
        boolean matchBonus = lottoNumbers.contains(bonusNumber);

        return LottoRank.valueOf(matchCnt, matchBonus);
    }
}
