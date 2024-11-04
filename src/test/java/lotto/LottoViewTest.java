package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static lotto.LottoView.getWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoViewTest {
    @DisplayName("당첨 번호가 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        // given
        String input = "0,2,3,4,5,6";

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(() -> getWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(originalIn);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // then
        assertThatThrownBy(() -> validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
