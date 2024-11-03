package lotto.domain.play;

import lotto.domain.rule.PrizeRank;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoInventoryTest {
    private static final LottoNumber BONUS = LottoNumber.of(7);
    private static final Lotto FIRST = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Lotto SECOND = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    private static final Lotto THIRD = new Lotto(List.of(1, 2, 3, 4, 5, 16));
    private static final Lotto FOURTH = new Lotto(List.of(1, 2, 3, 4, 15, 16));
    private static final Lotto FIFTH = new Lotto(List.of(1, 2, 3, 14, 15, 16));
    private static final Lotto LOSE = new Lotto(List.of(1, 2, 13, 14, 15, 16));

    @DisplayName("당첨 내역의 갯수를 반환하는지 확인")
    @Test
    void testFindCount() {
        LottoInventory lottoInventory = new LottoInventory(List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, LOSE));
        WinCriteria winCriteria = new WinCriteria(FIRST, BONUS);

        Result actual = lottoInventory.calculateResult(winCriteria);

        for (PrizeRank prizeRank : PrizeRank.values()) {
            assertThat(actual.findCount(prizeRank)).isEqualTo(1);
        }
    }
}