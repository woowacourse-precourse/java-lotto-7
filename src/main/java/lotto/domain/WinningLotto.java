package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }

    private void validateBonusNumberDuplicate(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호랑 보너스 번호가 중복됩니다.");
        }
    }
}