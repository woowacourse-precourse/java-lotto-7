package lotto.domain.result;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import lotto.domain.exception.LottoException;
import lotto.domain.exception.LottoNumberExceptionMessage;
import lotto.domain.rank.LottoRank;
import lotto.util.ValidLottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    public static final int MATCH_THREE = 3;
    public static final int MATCH_FOUR = 4;
    public static final int MATCH_FIVE = 5;
    public static final int MATCH_SIX = 6;

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoResultChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        validateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lottos checkLottosRank(final Lottos lottos) {
        return new Lottos(lottos.lottos().stream().map(this::checkRank).toList());
    }

    public Lotto checkRank(final Lotto lotto) {
        final long matchingCount = lotto.countWinningNumbers(this.winningNumbers);
        final boolean hasBonus = lotto.containsBonusNumber(this.bonusNumber);

        final LottoRank rank = validRank(matchingCount, hasBonus);

        return lotto.withRank(rank);
    }

    private LottoRank validRank(final long matchingCount, final boolean hasBonus) {
        if (matchingCount == MATCH_SIX) {
            return LottoRank.FIRST;
        }

        if (matchingCount == MATCH_FIVE && hasBonus) {
            return LottoRank.SECOND;
        }

        if (matchingCount == MATCH_FIVE) {
            return LottoRank.THIRD;
        }

        if (matchingCount == MATCH_FOUR) {
            return LottoRank.FOURTH;
        }

        if (matchingCount == MATCH_THREE) {
            return LottoRank.FIFTH;
        }

        return LottoRank.NO_MATCH;
    }

    private void validateNumber(final List<Integer> winningNumbers, final int bonusNumber) {
        if (ValidLottoNumber.isNotBoundedNumbers(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isNotBoundedNumber(bonusNumber)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isNotSixNumbers(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBERS_LENGTH_EXCEPTION);
        }

        if (ValidLottoNumber.isDuplicate(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.DUPLICATE_EXCEPTION);
        }
    }
}
