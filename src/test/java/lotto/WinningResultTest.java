package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨 번호 6개와 로또 번호를 비교하여 몇 개가 맞는지 센다.")
    @Test
    void test1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        WinningResult result = new WinningResult();
        int matchCount = result.countMatch(winnerNumbers, lotto);

        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 로또 번호에 포함되어 있는지 확인한다.")
    @Test
    void test2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        WinnerNumbers winnerNumbers2 = new WinnerNumbers(List.of(1, 2, 3, 4, 5, 7), 6);

        WinningResult result = new WinningResult();
        boolean hasMatchNumber = result.hasMatchNumber(winnerNumbers, lotto);
        boolean hasMatchNumber2 = result.hasMatchNumber(winnerNumbers2, lotto);

        assertThat(hasMatchNumber).isFalse();
        assertThat(hasMatchNumber2).isTrue();
    }

}
