package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    @DisplayName("당첨 금액을 계산한다")
    @Test
    void test1() {
        EnumMap<Rank, Integer> counts = new EnumMap<>(Rank.class);
        counts.put(Rank.FIRST, 1);
        counts.put(Rank.SECOND, 1);
        Money money = new Money(10000);
        WinningResult result = new WinningResult(counts, money);

        BigDecimal totalPrize = result.calculateTotalPrize();

        assertThat(totalPrize).isEqualTo(BigDecimal.valueOf(2_030_000_000));
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void test2() {
        EnumMap<Rank, Integer> counts = new EnumMap<>(Rank.class);
        counts.put(Rank.FIRST, 1);
        counts.put(Rank.SECOND, 1);
        Money money = new Money(10000);
        WinningResult result = new WinningResult(counts, money);

        BigDecimal value = result.calculatePrizeRate();

        // 실제로 소숫점 둘째자리를 xxx.00으로 입력하면 xxx.0으로 입력되기 때문
        assertThat(value.toString()).isEqualTo("20300000.0");
    }
}
