package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
    }

    @Test
    @DisplayName("6개의 번호가 모두 일치하는 경우 1등을 반환")
    void 일등_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(1);
    }

    @Test
    @DisplayName("5개의 번호와 보너스 번호가 일치하는 경우 2등을 반환")
    void 이등_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(2);
    }

    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호는 일치하지 않는 경우 3등을 반환")
    void 삼등_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(3);
    }

    @Test
    @DisplayName("4개의 번호가 일치하는 경우 4등을 반환")
    void 사등_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(4);
    }

    @Test
    @DisplayName("3개의 번호가 일치하는 경우 5등을 반환")
    void 오등_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(5);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치하는 경우 등수 없음(0등)을 반환")
    void 꽝_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));
        int rank = winningNumbers.calculateRank(lotto);
        assertThat(rank).isEqualTo(0);
    }
}