package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class WinningStatisticsTest {

    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = WinningStatistics.create();
    }

    @DisplayName("당첨 통계를 생성하면 미당첨 부터 1등 까지 모두 당첨 횟수 0을 갖는다.")
    @EnumSource(value = LottoRank.class)
    @ParameterizedTest
    void 당첨_통계_초기화(LottoRank lottoRank) {
        assertThat(winningStatistics.getWinningCount(lottoRank)).isEqualTo(0L);
    }

    @DisplayName("당첨 통계에 등수를 저장하면 당첨 횟수가 1 증가한다.")
    @EnumSource(value = LottoRank.class)
    @ParameterizedTest
    void 당첨_통계_저장(LottoRank lottoRank) {
        winningStatistics.save(lottoRank);

        assertThat(winningStatistics.getWinningCount(lottoRank)).isEqualTo(1L);
    }

    @DisplayName("정확한 소수점 계산과 순환 소수 방지를 위해 최대 16자리로(마지막 자리 밑에서 반올림) 제한해 수익률을 계산한다.")
    @CsvSource(value = {"8000,0.625", "3000,1.666666666666667"})
    @ParameterizedTest
    void 당첨_통계_수익률_계산(long totalAmount, String expectedRateOfReturn) {
        winningStatistics.save(LottoRank.FIFTH);

        assertThat(winningStatistics.calculateReturnOnInvestment(totalAmount).toString())
                .isEqualTo(expectedRateOfReturn);
    }

}
