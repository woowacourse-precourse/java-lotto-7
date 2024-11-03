package lotto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.util.CreateWinningMap;
import lotto.domain.util.CreateWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 3개가 맞으면 해당 당첨 금액을 반환한다.")
    void compareWinningTest1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<String, Integer> winningDetail = CreateWinningMap.create();
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9, 10);

        long winningAmount = lotto.compareWinning(winningNumbers, winningDetail);

        Assertions.assertThat(winningAmount).isEqualTo(5000L);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 4개가 맞으면 해당 당첨 금액을 반환한다.")
    void compareWinningTest2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<String, Integer> winningDetail = CreateWinningMap.create();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 7, 8, 9);

        long winningAmount = lotto.compareWinning(winningNumbers, winningDetail);

        Assertions.assertThat(winningAmount).isEqualTo(50_000L);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 5개가 맞으면 해당 당첨 금액을 반환한다.")
    void compareWinningTest3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<String, Integer> winningDetail = CreateWinningMap.create();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7, 8);

        long winningAmount = lotto.compareWinning(winningNumbers, winningDetail);

        Assertions.assertThat(winningAmount).isEqualTo(1_500_000L);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 5개와 보너스 번호가 맞으면 해당 당첨 금액을 반환한다.")
    void compareWinningTest4() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<String, Integer> winningDetail = CreateWinningMap.create();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7, 6);

        long winningAmount = lotto.compareWinning(winningNumbers, winningDetail);

        Assertions.assertThat(winningAmount).isEqualTo(30_000_000L);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 비교하여 6개가 맞으면 해당 당첨 금액을 반환한다.")
    void compareWinningTest5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<String, Integer> winningDetail = CreateWinningMap.create();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        long winningAmount = lotto.compareWinning(winningNumbers, winningDetail);

        Assertions.assertThat(winningAmount).isEqualTo(2_000_000_000L);
    }
}
