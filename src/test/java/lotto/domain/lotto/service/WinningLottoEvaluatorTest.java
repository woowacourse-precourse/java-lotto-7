package lotto.domain.lotto.service;

import static lotto.domain.lotto.vo.LottoPrize.FIFTH;
import static lotto.domain.lotto.vo.LottoPrize.FIRST;
import static lotto.domain.lotto.vo.LottoPrize.FOURTH;
import static lotto.domain.lotto.vo.LottoPrize.LOSE;
import static lotto.domain.lotto.vo.LottoPrize.SECOND;
import static lotto.domain.lotto.vo.LottoPrize.THIRD;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.vo.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLottoEvaluator 클래스 테스트")
class WinningLottoEvaluatorTest {

    private final WinningLottoEvaluator winningLottoEvaluator = new WinningLottoEvaluator();

    @Test
    void 번호가_여섯개가_동일하다면_1등을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 3, 4, 5, 6)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(FIRST);
    }

    @Test
    void 번호가_다섯개가_동일하고_보너스_번호가_일치하면_2등을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 3, 4, 5, 7)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(SECOND);
    }

    @Test
    void 번호가_다섯개가_동일하면_3등을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 3, 4, 5, 8)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(THIRD);
    }

    @Test
    void 번호가_네개가_동일하면_4등을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 3, 4, 9, 10)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(FOURTH);
    }

    @Test
    void 번호가_세개가_동일하면_5등을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 3, 8, 9, 10)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(FIFTH);
    }

    @Test
    void 번호가_두개가_동일하면_미당첨을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 2, 7, 8, 9, 10)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(LOSE);
    }

    @Test
    void 번호가_한개가_동일하면_미당첨을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(1, 7, 8, 9, 10, 11)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(LOSE);
    }

    @Test
    void 번호가_일치하지_않으면_미당첨을_반환한다() {
        // given
        WinningNumber winningNumber = 당첨_번호_생성();

        // when
        LottoPrize lottoPrize = winningLottoEvaluator.evaluate(winningNumber,
            Lotto.from(List.of(7, 8, 9, 10, 11, 12)));

        // then
        Assertions.assertThat(lottoPrize).isEqualTo(LOSE);
    }

    private WinningNumber 당첨_번호_생성() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        return WinningNumber.of(numbers, bonusNumber);
    }
}
