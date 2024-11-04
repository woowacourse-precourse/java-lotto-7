package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryResultTest {

    List<List<Integer>> lottoNumbers;
    List<Integer> winningNumbers;
    Integer bonusNumber;

    @DisplayName("등수별 로또 개수를 세서 맵 형태로 리턴한다.")
    @Test
    void returnCounts() {
        lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6), // 4개 일치 (4등)
                List.of(1, 12, 13, 14, 15, 16), // 1개 일치
                List.of(21, 22, 23, 24, 25, 26) // 1개 일치
        );
        winningNumbers = List.of(18, 1, 2, 3, 4, 21);
        bonusNumber = 45;
        LotteryResult result = new LotteryResult(lottoNumbers, winningNumbers, bonusNumber);
        Map<Rank, BigInteger> counts = result.returnCounts();
        assertThat(counts.size()).isEqualTo(6);
        assertThat(counts.get(Rank.FOURTH)).isEqualTo(BigInteger.valueOf(1));
        assertThat(counts.get(Rank.BLANK)).isEqualTo(BigInteger.valueOf(2));
    }

    @DisplayName("수익률을 계산하여 리턴한다.")
    @Test
    void returnRate() {
        lottoNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6), // 4개 일치 (4등)
                List.of(1, 12, 13, 14, 15, 16), // 1개 일치
                List.of(21, 22, 23, 24, 25, 26) // 1개 일치
        );
        winningNumbers = List.of(18, 1, 2, 3, 4, 21);
        bonusNumber = 45;
        LotteryResult result = new LotteryResult(lottoNumbers, winningNumbers, bonusNumber);
        // 50,000 / 3000 * 100 = 1666.7
        BigDecimal returnRate = result.returnRate();
        assertThat(returnRate.setScale(1, RoundingMode.HALF_UP)).isEqualTo("1666.7");
    }

    @DisplayName("수익률이 0일 경우에도 각 등수별 key를 갖는다.")
    @Test
    void zeroReturnRate() {
        lottoNumbers = List.of(
                List.of(11, 22, 3, 4, 5, 6), // 2개 일치
                List.of(11, 2, 3, 4, 5, 6), // 1개 일치
                List.of(1, 2, 3, 4, 5, 6) // 0개 일치
        );
        winningNumbers = List.of(18, 11, 22, 33, 44, 21);
        bonusNumber = 45;
        LotteryResult result = new LotteryResult(lottoNumbers, winningNumbers, bonusNumber);
        BigDecimal returnRate = result.returnRate();
        assertThat(returnRate.setScale(1, RoundingMode.HALF_UP)).isEqualTo("0.0");
    }

}