package lotto.model;

import java.util.HashMap;
import java.util.stream.Stream;
import lotto.dummy.LottoDummy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @DisplayName("로또를 생성할 때 번호는 오름차순으로 저장된다.")
    @Test
    void 로또를_생성할_때_번호는_오름차순으로_저장된다() {
        // given
        Lotto lotto = new Lotto(List.of(10, 9, 8, 7, 6, 5));

        // when
        List<Integer> numbers = lotto.getNumbers();

        // then
        for (int i = 1; i < numbers.size(); i++) {
            assertThat(numbers.get(i - 1) < numbers.get(i)).isTrue();
        }
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidSizeWinningNumberList")
    void 당첨_번호가_6개가_아닐_경우_에러가_발생한다(List<Integer> input) {
        Assertions.assertThatThrownBy(() -> {
            new Lotto(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨로또에 해당하는 등수를 반환할 수 있다.")
    @Test
    void 당첨로또에_해당하는_등수를_반환할_수_있다() {
        // given
        LottoDummy lottoDummy = new LottoDummy();
        List<Lotto> lottoList = lottoDummy.getLottoList();
        WinningLotto winningLotto = lottoDummy.winningLotto;
        HashMap<Lotto, LottoRank> lottoResult = lottoDummy.lottoResult;

        // when
        List<LottoRank> actualRankList = lottoList.stream().map(lotto -> lotto.getRankFrom(winningLotto)).toList();

        // then
        List<LottoRank> expectedRankList = lottoResult.values().stream().toList();
        Assertions.assertThat(actualRankList).isEqualTo(expectedRankList);
    }

    @DisplayName("로또의 범위가 맞지 않으면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidRangeNumberList")
    void 로또의_범위가_맞지_않으면_에러가_발생한다(List<Integer> numberList) {
        Assertions.assertThatThrownBy(() -> {
            new Lotto(numberList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> invalidSizeWinningNumberList() {
        return Stream.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 3),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5)
        );
    }

    private static Stream<List<Integer>> generateInvalidRangeNumberList() {
        return Stream.of(
                List.of(0, 2, 3, 5, 46, 99),
                List.of(99, 999, 9999, 99999, 999999, 9999999)
                );
    }
}
