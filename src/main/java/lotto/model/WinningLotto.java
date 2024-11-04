package lotto.model;

import lotto.common.constant.WinningInfo;
import lotto.exception.BonusNumberException;

import java.util.List;

import static lotto.common.constant.ErrorMessage.WINNING_NUMBER_CONTAINS_BONUS_NUMBER;

public class WinningLotto {
    private final WinningLottoNumber winningLottoNumber;
    private final BonusNumber bonusNumber;

    private WinningLotto(WinningLottoNumber winningLottoNumber, BonusNumber bonusNumber) {
        this.winningLottoNumber = winningLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(WinningLottoNumber winningLottoNumber, BonusNumber bonusNumber) {
        return new WinningLotto(winningLottoNumber, bonusNumber);
    }

    public WinningInfo matchWithLotto(List<Integer> lottoNumbers) {
        Long matchCount = winningLottoNumber.getMatchCountWithWinningLottoNumber(lottoNumbers);
        if (checkSecondPrize(matchCount, lottoNumbers)) {
            return WinningInfo.getWinningInfoMatchWithCount(matchCount, true);
        }
        return WinningInfo.getWinningInfoMatchWithCount(matchCount, false);
    }

    private boolean checkSecondPrize(Long matchCount, List<Integer> lottoNumbers) {
        return matchCount.equals(5L) && bonusNumber.isMatchWithLottoNumber(lottoNumbers);
    }
}
