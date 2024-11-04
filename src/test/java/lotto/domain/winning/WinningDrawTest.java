package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

class WinningDrawTest {

    @DisplayName("당첨 번호와 보너스 번호 1개를 넣으면 당첨번호 추첨에 성공 한다.")
    @Test
    void 당첨번호와_보너스번호_추첨_성공() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertDoesNotThrow(() -> WinningDraw.draw(Lotto.issue(winningNumbers), LottoBall.draw(bonusNumber)));
    }

    @DisplayName("당첨 번호로 로또 발행을 실패하면 예외가 발생한다.")
    @MethodSource("provideWrongWinningNumbers")
    @ParameterizedTest
    void 당첨번호_추첨_실패(List<Integer> winningNumbers) {
        int bonusNumber = 7;

        assertThatThrownBy(() -> WinningDraw.draw(Lotto.issue(winningNumbers), LottoBall.draw(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재하면 예외가 발생한다.")
    @Test
    void 보너스_번호_추첨_실패() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> WinningDraw.draw(Lotto.issue(winningNumbers), LottoBall.draw(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 주면 당첨을 비교해준다.")
    @MethodSource("provideNumbersAndLottoRank")
    @ParameterizedTest
    void 당첨_확인(List<Integer> numbers, LottoRank expectedRank) {
        WinningDraw winningDraw = WinningDraw.draw(Lotto.issue(List.of(1, 2, 3, 4, 5, 6)), LottoBall.draw(7));
        Lotto lotto = Lotto.issue(numbers);

        assertThat(winningDraw.compareWithWinningLotto(lotto)).isEqualTo(expectedRank);
    }

    static Stream<Arguments> provideWrongWinningNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }

    static Stream<Arguments> provideNumbersAndLottoRank() {
        return Stream.of(
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), LottoRank.NONE),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), LottoRank.NONE),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10), LottoRank.NONE),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), LottoRank.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), LottoRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), LottoRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoRank.FIRST)
        );
    }

}
