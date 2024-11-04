package lotto;

import lotto.input.BonusNumberValidator;
import lotto.input.WinningNumbersValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine(List.of(1,2,3,4,5,6), 7);
    }

    @Test
    @DisplayName("당첨 통계를 카운트하는 기능 테스트")
    void winningStatistics() {
        // given
        List<Lotto> lottoBatch = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 6 matches
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 5 matches + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),  // 5 matches
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4 matches
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 13)) // 3 matches
        );

        // when
        lottoMachine.calculateWinningStatistics(lottoBatch);
        lottoMachine.displayWinningStatistics();

        // then
        assertThat(lottoMachine.getTotalPrize())
                .isEqualTo(2031555000);
    }

    @Test
    @DisplayName("당첨 없는 경우 테스트")
    void noWinningStatistics() {
        // given
        List<Lotto> lottoBatch = Arrays.asList(
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(11, 12, 13, 41, 15, 17)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 20)),
                new Lotto(Arrays.asList(11, 21, 13, 14, 20, 31)),
                new Lotto(Arrays.asList(11, 21, 31, 40, 41, 43))
        );

        // when
        lottoMachine.calculateWinningStatistics(lottoBatch);
        lottoMachine.displayWinningStatistics();

        // then
        assertThat(lottoMachine.getTotalPrize())
                .isEqualTo(0);
    }
}