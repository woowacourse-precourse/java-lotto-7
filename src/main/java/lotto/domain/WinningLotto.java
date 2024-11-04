package lotto.domain;

import java.util.Arrays;
import lotto.constant.Rank;
import lotto.dto.LottoResult;

public class WinningLotto {
    private final Lotto ticket;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto ticket, BonusNumber bonusNumber) {
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto ticket, BonusNumber bonusNumber) {
        return new WinningLotto(ticket, bonusNumber);
    }

    /**
     * 고객의 로또를 당첨 번호와 비교하여 결과를 확인합니다.
     *
     * @param customerLotto 고객이 제출한 로또 티켓
     * @return 고객의 티켓 순위를 나타내는 LottoResult 객체
     */
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
