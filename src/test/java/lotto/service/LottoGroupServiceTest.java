package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Winning;
import org.junit.jupiter.api.Test;

class LottoGroupServiceTest {
    LottoGroupService lottoGroupService = new LottoGroupService();

    @Test
    void 결과_계산_테스트() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> userLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );
        LottoGroup lottoGroup = new LottoGroup(userLottos);

        lottoGroupService.calculateResults(lottoGroup, winningLotto, bonusNumber);

        Map<Winning, Integer> matchCounts = lottoGroup.getMatchCounts();
        assertEquals(1, matchCounts.get(Winning.SIXTH));
        assertEquals(1, matchCounts.get(Winning.FIFTH_WITH_BONUS));

        int expectedTotalPrize = Winning.SIXTH.getPrice() + Winning.FIFTH_WITH_BONUS.getPrice();
        assertEquals(expectedTotalPrize, lottoGroup.getTotalPrize());
    }
}