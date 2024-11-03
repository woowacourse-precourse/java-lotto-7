package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("등수별 로또 개수를 세서 맵 형태로 리턴한다.")
    @Test
    void returnCounts() {
        Result result = new Result(List.of(Rank.BLANK, Rank.BLANK, Rank.FIFTH, Rank.FOURTH, Rank.FOURTH));
        Map<Rank, BigInteger> counts = result.returnCounts();
        assertThat(counts.size()).isEqualTo(6);
        assertThat(counts.get(Rank.FIFTH)).isEqualTo(BigInteger.valueOf(1));
        assertThat(counts.get(Rank.FOURTH)).isEqualTo(BigInteger.valueOf(2));
    }

    @DisplayName("수익률을 계산하여 리턴한다.")
    @Test
    void returnRate() {
        Result result = new Result(List.of(Rank.BLANK, Rank.BLANK, Rank.FIFTH, Rank.FOURTH, Rank.FOURTH));
        // (5,000 + 50,000 + 50,000) / 5000 * 100 = 2,100
        BigDecimal returnRate = result.returnRate(new BigInteger("5000"));
        assertThat(returnRate.setScale(1, RoundingMode.HALF_UP)).isEqualTo("2100.0");
    }

    @DisplayName("수익률이 0일 경우에도 각 등수별 key를 갖는다.")
    @Test
    void zeroReturnRate() {
        Result result = new Result(List.of(Rank.BLANK, Rank.BLANK, Rank.BLANK, Rank.BLANK, Rank.BLANK));
        // (5,000 + 50,000 + 50,000) / 5000 * 100 = 2,100
        BigDecimal returnRate = result.returnRate(new BigInteger("5000"));
        assertThat(returnRate.setScale(1, RoundingMode.HALF_UP)).isEqualTo("0.0");
    }
}