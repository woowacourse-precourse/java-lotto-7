package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCalculatorTest {

    @DisplayName("3개의 숫자가 같을 경우, matchCount는 3이다")
    @Test
    void match_number_3() {
        assertMatchCount(
                List.of(1, 2, 3, 10, 20, 30),
                List.of(1, 2, 3, 4, 5, 6),
                3);
    }

    @DisplayName("4개의 숫자가 같을 경우, matchCount는 4이다")
    @Test
    void match_number_4() {
        assertMatchCount(
                List.of(1, 2, 3, 4, 10, 20),
                List.of(1, 2, 3, 4, 5, 6),
                4);
    }

    @DisplayName("5개의 숫자가 같을 경우, matchCount는 5이다")
    @Test
    void match_number_5() {
        assertMatchCount(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 7),
                5);
    }

    @DisplayName("6개의 숫자가 같을 경우, matchCount는 6이다")
    @Test
    void match_number_6() {
        assertMatchCount(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 6),
                6);
    }

    @DisplayName("보너스 번호가 당첨번호에 포함되어 있다면, true를 반환한다")
    @Test
    void winning_number_contains_bonus_number_then_true() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(lottoNumbers,
                bonusNumber);
        assertThat(bonusNumberMatched).isTrue();
    }

    @DisplayName("보너스 번호가 당첨번호에 포함되어 있지 않다면, false를 반환한다")
    @Test
    void winning_number_not_contains_bonus_number_then_true() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        boolean bonusNumberMatched = WinningCalculator.isBonusNumberMatched(lottoNumbers,
                bonusNumber);
        assertThat(bonusNumberMatched).isFalse();
    }

    private void assertMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers,
            int expectedMatchCount) {
        int actualMatchCount = WinningCalculator.countMatchingNumber(lottoNumbers, winningNumbers);
        assertThat(expectedMatchCount).isEqualTo(actualMatchCount);
    }

}
