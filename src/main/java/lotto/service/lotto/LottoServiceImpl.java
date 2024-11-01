package lotto.service.lotto;

import lotto.domain.bonus.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningResult;
import lotto.exception.lotto.LottoErrorMessages;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public boolean validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }
        return true;
    }

    @Override
    public WinningResult checkResult(Lotto lotto, WinningContext context) {
        WinningNumbers winningNumbers = context.getWinningNumbers();
        BonusNumber bonusNumber = context.getBonusNumber();

        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNums = winningNumbers.getNumbers();
        int matchCount = (int) lottoNumbers.stream().filter(winningNums::contains).count();
        boolean hasBonus = lottoNumbers.contains(bonusNumber.getNumber());

        return determineRank(matchCount, hasBonus);
    }

    private WinningResult determineRank(int matchCount, boolean hasBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && (!rank.hasBonus() || hasBonus)) {
                return new WinningResult(rank);
            }
        }
        return new WinningResult(Rank.NO_WIN);
    }
}

