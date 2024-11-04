package lotto.controller;

import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumbersControllerTest {

    @DisplayName("로또번호와 보너스번호를 입력하면 해당 값 객체를 생성한다.")
    @Test
    void determineLottoWinningNumbers() {

        // given
        LottoWinningNumbersController controller = new LottoWinningNumbersController();
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        LottoWinningNumbers lottoWinningNumbers = controller.determineLottoWinningNumbers(winningNumbers, bonusNumber);

        // then
        assertThat(lottoWinningNumbers.getWinningNumbers()).hasSize(6)
            .containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
        assertThat(lottoWinningNumbers.getBonusWinningNumber()).isEqualTo(bonusNumber);
    }

}