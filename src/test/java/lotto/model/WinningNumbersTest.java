package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @DisplayName("당첨 번호는 1부터 45 중 중복되지 않는 6개의 숫자이다.")
    @Test
    void winningNumbers_ShouldBe_6NumbersAndBetween1And45() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusBall = 7;

        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusBall);
        List<Integer> lottoNumbers = winningNumbers.lotto().getNumbers();

        assertThat(lottoNumbers).hasSize(6);
        lottoNumbers.forEach(number -> assertThat(number).isBetween(1, 45));

        assertThat(winningNumbers.bonusBall()).isBetween(1, 45);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우 예외 처리")
    @Test
    void throwException_when_lottoNumberAndBonusBallAreDuplicated() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusBall = 6;

        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45까지의 숫자가 아닌 경우 예외 처리")
    @Test
    void throwException_when_bonusBallIsNotBetween1And45() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusBall = 46;

        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
