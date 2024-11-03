package lotto.handler.purchase.process;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void 로또_하나_생성() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 숫자 리스트를 문자열로 변환하면 특수기호 []가 포함돼야 한다.")
    @Test
    void 로또_번호_숫자_리스트를_문자열로_반환하면_특수기호가_포함돼야_한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.getDisplayNumbers());
    }

    @DisplayName("같은 숫자 별 알맞은 등수를 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("숫자에_따른_각_등수")
    void 같은_숫자_별_알맞은_등수를_반환해야_한다(List<Integer> winningNumbers, int bonusNumber, WinningRank expectedRank) {
        WinningRank resultRank = lotto.getRank(winningNumbers, bonusNumber);
        Assertions.assertEquals(expectedRank, resultRank);
    }

    private static Stream<Arguments> 숫자에_따른_각_등수() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, WinningRank.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), 6, WinningRank.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 20), 7, WinningRank.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 20, 30), 7, WinningRank.FOURTH),
                Arguments.of(List.of(1, 2, 3, 10, 20, 30), 4, WinningRank.FIFTH),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 17, WinningRank.LOSE)
        );
    }
}
