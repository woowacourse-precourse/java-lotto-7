package lotto.domain;

import static lotto.domain.LottoPrize.FIFTH_PRIZE;
import static lotto.domain.LottoPrize.FOURTH_PRIZE;
import static lotto.domain.LottoPrize.FRIST_PRIZE;
import static lotto.domain.LottoPrize.SECOND_PRIZE;
import static lotto.domain.LottoPrize.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStaticsTest {

    @Test
    void 로또통계를_생성한다() {
        //given
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);
        Money money = Money.from(3000);

        //expected
        assertThatCode(() -> LottoStatics.of(lottos, winningLotto, money))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또통계_생성시_로또가_null이면_예외가_발생한다() {
        //given
        List<Lotto> lottos = null;
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);
        Money money = Money.from(3000);

        //expected
        assertThatThrownBy(() -> LottoStatics.of(lottos, winningLotto, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LottoStatics에 전달된 파라미터가 null입니다.");
    }

    @Test
    void 로또통계_생성시_당첨로또가_null이면_예외가_발생한다() {
        //given
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = null;
        Money money = Money.from(3000);

        //expected
        assertThatThrownBy(() -> LottoStatics.of(lottos, winningLotto, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LottoStatics에 전달된 파라미터가 null입니다.");
    }

    @Test
    void 로또통계_생성시_돈이_null이면_예외가_발생한다() {
        //given
        List<Lotto> lottos = getLottos();
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);
        Money money = null;

        //expected
        assertThatThrownBy(() -> LottoStatics.of(lottos, winningLotto, money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("LottoStatics에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndPrizeCount")
    void 당첨내역을_확인할_수_있다(WinningLotto winningLotto, List<Integer> expectedPrizeCount) {
        //given
        List<Lotto> lottos = getLottos();
        Money money = Money.from(3000);
        LottoStatics sut = LottoStatics.of(lottos, winningLotto, money);

        //when
        EnumMap<LottoPrize, Long> result = sut.getPrizeCount();

        //then
        assertThat(result.get(FIFTH_PRIZE)).isEqualTo(expectedPrizeCount.get(0));
        assertThat(result.get(FOURTH_PRIZE)).isEqualTo(expectedPrizeCount.get(1));
        assertThat(result.get(THIRD_PRIZE)).isEqualTo(expectedPrizeCount.get(2));
        assertThat(result.get(SECOND_PRIZE)).isEqualTo(expectedPrizeCount.get(3));
        assertThat(result.get(FRIST_PRIZE)).isEqualTo(expectedPrizeCount.get(4));
    }

    @ParameterizedTest
    @MethodSource("provideWinningLottoAndIncomeRate")
    void 수익률을_확인할_수_있다(WinningLotto winningLotto, double expectedIncomeRate) {
        List<Lotto> lottos = getLottos();
        Money money = Money.from(3000);
        LottoStatics sut = LottoStatics.of(lottos, winningLotto, money);

        //when
        double result = sut.getIncomePercent();

        //then
        assertThat(result).isEqualTo(expectedIncomeRate);
    }

    private static Stream<Arguments> provideWinningLottoAndPrizeCount() {
        return Stream.of(
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7),
                        List.of(0L, 0L, 0L, 0L, 1L)
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), 8),
                        List.of(1L, 0L, 1L, 0L, 0L)
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), 1),
                        List.of(1L, 0L, 0L, 1L, 0L)
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(3, 4, 5, 6, 9, 10)), 15),
                        List.of(0L, 2L, 0L, 0L, 0L)
                )
        );
    }

    private static Stream<Arguments> provideWinningLottoAndIncomeRate() {
        return Stream.of(
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7),
                        (double) (FRIST_PRIZE.prizeMoney) * 100 / 3000
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), 8),
                        (double) (FIFTH_PRIZE.prizeMoney + THIRD_PRIZE.prizeMoney) * 100 / 3000
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(2, 3, 4, 5, 6, 7)), 1),
                        (double) (FIFTH_PRIZE.prizeMoney + SECOND_PRIZE.prizeMoney) * 100 / 3000
                ),
                Arguments.of(
                        WinningLotto.of(Lotto.from(List.of(3, 4, 5, 6, 9, 10)), 15),
                        (double) (FOURTH_PRIZE.prizeMoney * 2) * 100 / 3000
                )
        );
    }

    private static List<Lotto> getLottos() {
        return List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(5, 6, 7, 8, 9, 10)),
                Lotto.from(List.of(9, 10, 11, 12, 13, 14))
        );
    }
}
