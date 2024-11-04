package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다")
    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class, () -> Lotto.validateBonusNumber(winningNumbers, 0), "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        assertThrows(IllegalArgumentException.class, () -> Lotto.validateBonusNumber(winningNumbers, 46), "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatThrownBy(() -> Lotto.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("로또 당첨 결과를 검증")
    @Test
    void 로또_당첨_결과_검증() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        assertEquals(LottoRank.NONE, lotto.match(Arrays.asList(10, 11, 12, 13, 14, 15), 7), "0개 일치");
        assertEquals(LottoRank.FIFTH, lotto.match(Arrays.asList(1, 11, 2, 3, 14, 15), 7), "3개 일치");
        assertEquals(LottoRank.FOURTH, lotto.match(Arrays.asList(1, 2, 12, 3, 4, 15), 7), "4개 일치");
        assertEquals(LottoRank.THIRD, lotto.match(Arrays.asList(1, 2, 3, 13, 4, 5), 7), "5개 일치");

        assertEquals(LottoRank.SECOND, lotto.match(Arrays.asList(1, 2, 3, 4, 5, 15), 6), "5개 일치 + 보너스 볼 일치");

        assertEquals(LottoRank.FIRST, lotto.match(Arrays.asList(1, 2, 3, 4, 5, 6), 7), "6개 일치");
    }
}
