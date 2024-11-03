package lotto;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
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


    @Test
    void 로또_번호와_당첨번호_검수() {
        //Given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10);

        //When
        int matchCount = lotto.matchCount(winningNumbers);

        //Then
        assertEquals(3, matchCount);
    }

    @Test
    void 보너스_번호가_포함이_되었는지_검수() {
        //Given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 10);
        Lotto lotto = new Lotto(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9), 10);

        //When
        boolean hasBonus = lotto.hasBonusNumber(winningNumbers);

        //Then
        assertTrue(hasBonus);
    }

}
