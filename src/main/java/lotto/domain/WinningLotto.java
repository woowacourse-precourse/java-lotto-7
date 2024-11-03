package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.constant.Rank;
import lotto.dto.LottoResult;

public class WinningLotto {
    private final Lotto ticket;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto ticket, BonusNumber bonusNumber) {
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> ticket, BonusNumber bonusNumber) {
        return new WinningLotto(Lotto.of(ticket), bonusNumber);
    }

    public LottoResult checkLotto(Lotto customerLotto) {
        int matchedCount = getMatchedCount(customerLotto);
        boolean containsBonus = hasContainsBonusNumber(customerLotto);

        Rank rank = getRank(matchedCount, containsBonus);

        return LottoResult.of(rank);
    }

    private int getMatchedCount(Lotto customerLotto) {
        return ticket.getMatchedCount(customerLotto.getNumbers());
    }

    private Rank getRank(int matchedCount, boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchesCriteria(matchedCount, containsBonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private boolean hasContainsBonusNumber(Lotto customerLotto) {
        return customerLotto.getNumbers().contains(bonusNumber.getValue());
    }
}
