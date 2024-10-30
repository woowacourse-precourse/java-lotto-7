package lotto.domain.service;

import lotto.domain.entity.Lotto;
import lotto.domain.type.LottoRank;
import lotto.exception.LottoException;
import lotto.exception.LottoNumberExceptionMessage;
import lotto.util.ValidLottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    public static final int MATCH_THREE = 3;
    public static final int MATCH_FOUR = 4;
    public static final int MATCH_FIVE = 5;
    public static final int MATCH_SIX = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        validateNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkRank(final Lotto lotto) {

        final Set<Integer> winningNumbers = new HashSet<>(this.winningNumbers);

        final long matchingCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        final boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        return validRank(matchingCount, hasBonus);
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
        if (ValidLottoNumber.isBoundedNumbers(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isBoundedNumber(bonusNumber)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isSixNumbers(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBERS_LENGTH_EXCEPTION);
        }

        if (ValidLottoNumber.isDuplicate(winningNumbers)) {
            throw new LottoException(LottoNumberExceptionMessage.DUPLICATE_EXCEPTION);
        }
    }
}
