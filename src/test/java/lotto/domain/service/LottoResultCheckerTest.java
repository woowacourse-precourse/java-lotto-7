package lotto.domain.service;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import lotto.domain.type.LottoRank;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoResultCheckerTest {

    @Test
    void 로또_단건_결과에_따른_결과값_반환_테스트() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
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

    @Test
    void 로또_다건_리스트_결과에_따른_결과값_반환_테스트() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto fiveMatched = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        final Lotto fourMatched = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        final Lotto threeMatched = new Lotto(List.of(1, 2, 3, 12, 13, 14));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);
        // when
        final Lottos lottos = new Lottos(List.of(allMatched, fiveMatchedWithBonusNumber, fiveMatched, fourMatched, threeMatched));
        final List<LottoRank> lottoRanks = resultChecker.checkLottosRank(lottos);

        // then
        assertAll(
                () -> assertTrue(lottoRanks.contains(LottoRank.FIRST)),
                () -> assertTrue(lottoRanks.contains(LottoRank.SECOND)),
                () -> assertTrue(lottoRanks.contains(LottoRank.THIRD)),
                () -> assertTrue(lottoRanks.contains(LottoRank.FOURTH))
        );
    }

    @Test
    void 보너스_번호가_45보다_크면_예외처리() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 보너스_번호가_1보다_작으면_예외처리() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        final int bonusNumber = -1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 입력받은_당첨_번호가_1보다_작은경우() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(-1, 2, 3, 4, 5, 6));
        final int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 입력받은_당첨_번호가_45보다_큰경우() {
        // given
        final List<Integer> winningNumber = new ArrayList<>(List.of(46, 2, 3, 4, 5, 6));
        final int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }
}