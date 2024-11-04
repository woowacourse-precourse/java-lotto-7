package lotto.domain.result;

import lotto.ui.parser.InputParser;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import lotto.domain.rank.LottoRank;
import lotto.domain.exception.LottoException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoResultCheckerTest {
    
    @Test
    void 로또_단건_결과에_따른_결과값_반환_테스트() {
        // given
        final List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);
        // when
        final Lotto lottoRanksFirst = resultChecker.checkRank(allMatched);
        final Lotto lottoRanksSecond = resultChecker.checkRank(fiveMatchedWithBonusNumber);

        // then
        assertAll(
                () -> assertThat(lottoRanksFirst.getRank()).isEqualTo(LottoRank.FIRST),
                () -> assertThat(lottoRanksSecond.getRank()).isEqualTo(LottoRank.SECOND)
        );
    }

    @Test
    void 로또_다건_리스트_결과에_따른_결과값_반환_테스트() {
        // given
        final List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        final int bonusNumber = 7;

        List<LottoRank> ranksToCheck = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH);

        final Lotto allMatched = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchedWithBonusNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto fiveMatched = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        final Lotto fourMatched = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        final Lotto threeMatched = new Lotto(List.of(1, 2, 3, 12, 13, 14));

        final LottoResultChecker resultChecker = new LottoResultChecker(winningNumber, bonusNumber);
        // when
        final Lottos lottos = new Lottos(List.of(allMatched, fiveMatchedWithBonusNumber, fiveMatched, fourMatched, threeMatched));
        final Lottos lottosRank = resultChecker.checkLottosRank(lottos);

        // then
        assertTrue(lottosRank.lottos().stream().map(Lotto::getRank).anyMatch(ranksToCheck::contains));
    }

    @Test
    void 보너스_번호가_45보다_크면_예외처리() {
        // given
        final List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        final int bonusNumber = 46;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 보너스_번호가_1보다_작으면_예외처리() {
        // given
        final List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        final int bonusNumber = -1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 입력받은_당첨_번호가_1보다_작은경우() {
        // given
        final List<Integer> winningNumber = List.of(1,2,3,4,5,6);
        final int bonusNumber = -1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }

    @Test
    void 입력받은_당첨_번호가_45보다_큰경우() {
        // given
        final List<Integer> winningNumber = List.of(46,2,3,4,5,6);
        final int bonusNumber = 1;

        // when & then
        assertThatThrownBy(() -> {
            new LottoResultChecker(winningNumber, bonusNumber);
        }).isInstanceOf(LottoException.class);
    }
}