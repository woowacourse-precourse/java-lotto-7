package lotto.domain.service;


import lotto.domain.entity.Lotto;
import lotto.domain.type.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultCheckerTest {

    @Test
    void 로또_결과에_따른_결과값_반환_테스트() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(1,2,3,4,5,6));
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);
        // when
        final LottoRank lottoRanksFirst = resultChecker.checkRank(allMatched);
        final LottoRank lottoRanksSecond = resultChecker.checkRank(fiveMatchedWithBonusNumber);

        // then
        assertAll(
                () -> assertThat(lottoRanksFirst).isEqualTo(LottoRank.FIRST),
                () -> assertThat(lottoRanksSecond).isEqualTo(LottoRank.SECOND)
        );
    }
}