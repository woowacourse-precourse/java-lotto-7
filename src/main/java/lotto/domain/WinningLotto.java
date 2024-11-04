package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        validateDuplicate(winningLotto);
        validateBonusNumberDuplicate(winningLotto, bonusNumber);
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(numbers);
        if(lottoNumbers.size() != 6){
            throw new LottoException(LottoExceptionType.NOT_MATCH_LOTTONUMBER);
        }
    }

    private void validateBonusNumberDuplicate(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(LottoExceptionType.DUPLICATE_BONUS_NUMBER);
        }
    }

    public WinningRank match(Lotto userLotto) {
        int matchCount = countMatch(userLotto);
        boolean matchBonus = matchBonus(userLotto);
        return WinningRank.valueOf(matchCount, matchBonus);
    }

    private int countMatch(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }

    private boolean matchBonus(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }
}