package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    void bonusNumberDuplicatedWithWinningNumbers_throwsException() {
        WinningLotto winningLotto;
        assertThatThrownBy(() -> new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("유효한 당첨 번호와 보너스 번호로 WinningLotto 생성")
    void createWinningLotto_withValidNumbers() {
        WinningLotto winningLotto = new WinningLotto(
                Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }
}