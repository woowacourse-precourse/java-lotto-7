package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @Test
    void 당첨로또를_생성한다() {
        //given
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //expected
        assertThatCode(() -> WinningLotto.of(winningNumber, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨로또_생성시_보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        //given
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //expected
        assertThatThrownBy(() -> WinningLotto.of(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 당첨 번호와 중복되었습니다.");
    }

    @Test
    void 당첨로또_생성시_당첨번호가_null이면_예외가_발생한다() {
        //given
        Lotto winningNumber = null;
        int bonusNumber = 6;

        //expected
        assertThatThrownBy(() -> WinningLotto.of(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("WinningLotto에 전달된 파라미터가 null입니다.");
    }

    @Test
    void 당첨로또_생성시_보너스번호가_null이면_예외가_발생한다() {
        //given
        Lotto winningNumber = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = null;

        //expected
        assertThatThrownBy(() -> WinningLotto.of(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("WinningLotto에 전달된 파라미터가 null입니다.");
    }

    @ParameterizedTest
    @MethodSource("provideMatchLottoAndLottoPrize")
    void 당첨로또와_로또를_비교하여_당첨내역을_확인할_수_있다(List<Integer> lottoNumbers, Optional<LottoPrize> expectedPrize) {
        //given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto targetLotto = Lotto.from(lottoNumbers);

        //when
        Optional<LottoPrize> result = winningLotto.matchLotto(targetLotto);

        //then
        assertThat(result).isEqualTo(expectedPrize);
    }

    @Test
    void 당첨로또와_로또를_비교시_로또가_null이면_예외가_발생한다() {
        //given
        WinningLotto winningLotto = WinningLotto.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto targetLotto = null;

        //expected
        assertThatThrownBy(() -> winningLotto.matchLotto(targetLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("WinningLotto에 전달된 파라미터가 null입니다.");
    }

    private static Stream<Arguments> provideMatchLottoAndLottoPrize() {
        return Stream.of(
                Arguments.of(List.of(1, 11, 12, 13, 14, 15), Optional.empty()),
                Arguments.of(List.of(1, 2, 12, 13, 14, 15), Optional.empty()),
                Arguments.of(List.of(1, 2, 3, 13, 14, 15), Optional.of(LottoPrize.FIFTH_PRIZE)),
                Arguments.of(List.of(1, 2, 3, 4, 14, 15), Optional.of(LottoPrize.FOURTH_PRIZE)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 15), Optional.of(LottoPrize.THIRD_PRIZE)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), Optional.of(LottoPrize.SECOND_PRIZE)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), Optional.of(LottoPrize.FRIST_PRIZE))
        );
    }
}
