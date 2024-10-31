package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @DisplayName("당첨 번호는 1부터 45 중 중복되지 않는 6개의 숫자이다.")
    @Test
    void winningNumbersShouldBe6NumbersAndBetween1And45() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusBall = 7;

        WinningNumbers winningNumbers = new WinningNumbers(lotto, bonusBall);
        List<Integer> lottoNumbers = winningNumbers.lotto().getNumbers();

        assertThat(lottoNumbers).hasSize(6);
        lottoNumbers.forEach(number -> assertThat(number).isBetween(1, 45));

        assertThat(winningNumbers.bonusBall()).isBetween(1, 45);
    }
}
