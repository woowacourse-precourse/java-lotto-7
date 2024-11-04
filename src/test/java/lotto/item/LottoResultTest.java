package lotto.item;

import lotto.Lotto;
import lotto.common.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.common.WinningRank.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    public void 로또_결과가_정확한_상금을_반환하는지_테스트() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto1 = new Lotto(List.of(1,2,3,11,15,20));  // 5등
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,20));  // 3등
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,7));  // 2등

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottos);

        // when
        int winningAmount = lottoResult.getTotalWinningAmounts();

        // then
        Assertions.assertEquals(31505000, winningAmount);
    }

    @Test
    public void 로또_결과가_정확한_당첨_결과를_산출하는지_테스트() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto1 = new Lotto(List.of(1,2,3,11,15,20));  // 5등
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,20));  // 3등
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,7));  // 2등
        Lotto lotto4 = new Lotto(List.of(10, 11, 24, 13, 27, 9));  // 순위 외
        Lotto lotto5 = new Lotto(List.of(1, 30, 3, 4, 5, 6));  // 3등

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);

        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber, lottos);

        // when
        Map<WinningRank, Integer> winningInfoMap = lottoResult.getWinningResult();

        // then
        Assertions.assertEquals(0, winningInfoMap.get(FIRST_PLACE));
        Assertions.assertEquals(1, winningInfoMap.get(SECOND_PLACE));
        Assertions.assertEquals(2, winningInfoMap.get(THIRD_PLACE));
        Assertions.assertEquals(0, winningInfoMap.get(FOURTH_PLACE));
        Assertions.assertEquals(1, winningInfoMap.get(FIFTH_PLACE));
        Assertions.assertEquals(1, winningInfoMap.get(NOT_IN_PLACE));
    }
}