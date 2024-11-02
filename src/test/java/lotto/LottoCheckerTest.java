package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    @Test
    @DisplayName("6개 번호가 모두 일치 -> 1등")
    void check_1등_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 3, 4, 5, 6), winningNumbers);

        assertThat(result).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치 -> 2등")
    void check_2등_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 3, 4, 5, 7), winningNumbers);

        assertThat(result).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치 -> 3등")
    void check_3등_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 3, 4, 5, 8), winningNumbers);

        assertThat(result).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 번호가 일치 -> 4등")
    void check_4등_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 3, 4, 8, 9), winningNumbers);

        assertThat(result).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 번호가 일치 -> 5등")
    void check_5등_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 3, 8, 9, 10), winningNumbers);

        assertThat(result).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치 -> 등수 NONE")
    void check_등수없음_테스트() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoChecker checker = new LottoChecker();

        Rank result = checker.check(List.of(1, 2, 8, 9, 10, 11), winningNumbers);

        assertThat(result).isEqualTo(Rank.NONE);
    }
}