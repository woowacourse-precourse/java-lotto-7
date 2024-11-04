package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호의 개수가 5개 이하일 때 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_5개_이하일때_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 중복일 수 없습니다.");
    }

    @DisplayName("로또 번호에 1 미만의 숫자가 있으면 예외가 발생한다.")
    @Test
    void LottoNumberLowerThanOne() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 0)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 45를 초과하는 숫자가 있으면 예외가 발생한다.")
    @Test
    void LottoNumberUpperThan45() {
        assertThatThrownBy(() -> Lotto.createLotto(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호들을 출력한다.")
    @Test
    void printLotto() {

        // given
        Lotto lotto = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        String expectedResult = "[1, 2, 3, 4, 5, 6]";

        // when
        String printLotto = lotto.printLotto();

        // then
        assertThat(printLotto).isEqualTo(expectedResult);
    }

    @DisplayName("당첨 번호가 같이 주어지면, 해당 당첨결과를 출력한다.")
    @Test
    void calculatePrize() {

        // given
        Lotto lotto1 = Lotto.createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.createLotto(List.of(3, 4, 5, 6, 7, 8));

        Set<Integer> winningNumbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusWinningNumber = 7;
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers
            .createLottoWinningNumbers(winningNumbers, bonusWinningNumber);

        // when
        LottoPrize prize1 = lotto1.calculatePrize(lottoWinningNumbers);
        LottoPrize prize2 = lotto2.calculatePrize(lottoWinningNumbers);

        // then
        assertThat(prize1).isEqualTo(LottoPrize.FIRST_PRIZE);
        assertThat(prize2).isEqualTo(LottoPrize.FOURTH_PRIZE);
    }
}
