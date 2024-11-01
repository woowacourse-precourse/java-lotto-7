package lotto.domain;

import java.util.Arrays;
import lotto.constant.Rank;
import lotto.dto.LottoResult;

public class WinningLotto {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 %d와 %d사이 숫자여야합니다.";
    public static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";

    private final Lotto ticket;
    private final int bonusNumber;

    public WinningLotto(Lotto ticket, int bonusNumber) {
        validate(bonusNumber);
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLotto(Lotto customerLotto) {
        int matchedCount = getMatchedCount(customerLotto);
        boolean containsBonus = hasMatchingBonusNumber(customerLotto, matchedCount);

        Rank rank = getRank(matchedCount, containsBonus);

        return LottoResult.of(rank, matchedCount);
    }

    private void validate(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber);
    }

    private boolean containsDuplicateNumbers(int bonusNumber) {
        return ticket.getNumbers().stream().anyMatch(n -> n == bonusNumber);
    }

    private int getMatchedCount(Lotto customerLotto) {
        return ticket.getMatchedCount(customerLotto.getNumbers());
    }

    private boolean hasMatchingBonusNumber(Lotto customerLotto, int matchedCount) {
        return isSecondRank(matchedCount) && containsBonusNumber(customerLotto);
    }

    private Rank getRank(int matchedCount, boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCriteria(matchedCount, containsBonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private boolean isSecondRank(int matchedCount) {
        return matchedCount == Rank.SECOND.getMatchingNumberCount();
    }

    private boolean containsBonusNumber(Lotto customerLotto) {
        return customerLotto.getNumbers().contains(bonusNumber);
    }

    private void validateDuplicate(int bonusNumber) {
        if (containsDuplicateNumbers(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(String.format(BONUS_NUMBER_RANGE_ERROR_MESSAGE, MIN_RANGE, MAX_RANGE));
        }
    }
}
