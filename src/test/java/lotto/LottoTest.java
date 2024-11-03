package lotto;

import java.util.HashMap;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
        /* given */
        Lotto lotto = new Lotto(List.of(10, 9, 8, 7, 6, 5));

        /* when */
        List<Integer> numbers = lotto.getNumbers();

        /* then */
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
    @ParameterizedTest
    @MethodSource("generateLottoListAndWinningLotto")
    void 당첨로또에_해당하는_등수를_반환할_수_있다(Lotto lotto, WinningLotto winningLotto, LottoRank expectedRank) {
        // when
        LottoRank actualRank = lotto.getRankFrom(winningLotto);

        // then
        Assertions.assertThat(actualRank).isEqualTo(expectedRank);
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

    private static Stream<Arguments> generateLottoListAndWinningLotto() {
        WinningLotto winningNumber = new WinningLotto(
                new Lotto(List.of(7, 9, 13, 26, 29, 43)), 11
        );

        HashMap<Lotto, LottoRank> lottoResult = new HashMap<>();
        lottoResult.put(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 8, 11, 14, 15, 16)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 14, 15, 16)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 14, 15, 16)), LottoRank.RANK_5);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 27, 28)), LottoRank.RANK_4);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 29, 36)), LottoRank.RANK_3);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 13, 26, 29)), LottoRank.RANK_2);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 26, 29, 43)), LottoRank.RANK_2);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 29, 43)), LottoRank.RANK_1);

        return lottoResult.entrySet().stream()
                .map(lotto -> Arguments.of(lotto.getKey(), winningNumber, lotto.getValue()));
    }
}
