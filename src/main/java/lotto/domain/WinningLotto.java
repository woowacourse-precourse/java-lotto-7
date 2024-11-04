package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, final int bonusNumber) {
        this(new Lotto(winningLottoNumbers), new LottoNumber(bonusNumber));
    }

    public WinningLotto(final Lotto lotto, final LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 입력 받은 6개의 로또 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public LottoRank makeLottoRank(Lotto lotto) {
        int matchCount = getMatchCount(lotto);
        boolean matchBonus = checkLottoContainsBonusNumber(lotto);
        return LottoRank.of(matchCount, matchBonus);
    }

    private int getMatchCount(Lotto lotto) {
        return this.lotto.getMatchCount(lotto);
    }

    private boolean checkLottoContainsBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
