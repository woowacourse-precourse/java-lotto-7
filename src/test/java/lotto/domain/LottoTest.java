package lotto.domain;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성


    @DisplayName("로또 번호화 당첨 번호의 일치개수가 3으로 계산된다.")
    @Test
    void 로또_번호와_당첨_번호의_일치_개수가_3으로_계산된다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(winningNumbers);
        winningNumber.setBonusNumber(10);

        long matchCount = lotto.matchCount(winningNumber);
        assertEquals(3, matchCount); // 1, 2, 3이 일치
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있다.")
    @Test
    void 로또_번호에_보너스_번호가_포함되어_있다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setBonusNumber(3);
        winningNumber.setWinningNumbers(winningNumbers);

        assertTrue(lotto.containsBonus(winningNumber));
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않다.")
    @Test
    void 로또_번호에_보너스_번호가_포함되어_있지_않다() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(winningNumbers);
        winningNumber.setBonusNumber(13);

        assertFalse(lotto.containsBonus(winningNumber));
    }
}
