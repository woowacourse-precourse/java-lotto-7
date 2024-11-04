package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManagerTest {

    LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        lottoManager = new LottoManager(winningLotto, bonusNumber);
    }

    @Test
    @DisplayName("모든 번호가 일치하면 1등 상금을 반환한다.")
    void testFirstPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FIRST_PRIZE, 1);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등 상금을 반환한다.")
    void testSecondPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.SECOND_PRIZE, 1);
    }

    @Test
    @DisplayName("5개 번호가 일치하면 3등 상금을 반환한다.")
    void testThirdPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.THIRD_PRIZE, 1);
    }

    @Test
    @DisplayName("4개 번호가 일치하면 4등 상금을 반환한다.")
    void testFourthPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 3, 4, 8, 9)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FOURTH_PRIZE, 1);
    }

    @Test
    @DisplayName("3개 번호가 일치하면 5등 상금을 반환한다.")
    void testFifthPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 3, 8, 9, 10)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FIFTH_PRIZE, 1);
    }

    @Test
    @DisplayName("일치하는 번호가 2개 이하인 경우 상금이 없다.")
    void testNoPrize() {
        // Given
        List<Lotto> lotto = List.of(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        // When
        Map<LottoWinnerPrize, Integer> prizeCount = lottoManager.getWinningPrizes(lotto);

        // Then
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FIRST_PRIZE, 0);
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.SECOND_PRIZE, 0);
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.THIRD_PRIZE, 0);
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FOURTH_PRIZE, 0);
        assertThat(prizeCount).containsEntry(LottoWinnerPrize.FIFTH_PRIZE, 0);
    }
}
