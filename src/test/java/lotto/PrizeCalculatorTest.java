package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.Map;
import lotto.enums.Prize;
import lotto.model.PrizeCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeCalculatorTest {
    @DisplayName("정상적인 당첨금 계산의 경우 테스트")
    @Test
    void 정상적인_당첨금_계산의_경우_테스트() {
        // given
        Map<Prize, Long> prizeMap = new EnumMap<>(Prize.class);
        prizeMap.put(Prize.FIRST, 1L);
        prizeMap.put(Prize.SECOND, 2L);
        prizeMap.put(Prize.THIRD, 0L);
        long money = 10000000L;

        // when
        PrizeCalculator calculator = new PrizeCalculator(prizeMap, money);

        // then
        long expectedTotalPrize = Prize.FIRST.getPrize() * 1 + Prize.SECOND.getPrize() * 2;
        double expectedRate = 100.0 * expectedTotalPrize / money;
        assertThat(expectedTotalPrize).isEqualTo(calculator.getTotalPrize());
        assertThat(expectedRate).isEqualTo(calculator.calculatePrizeRate());

    }

    @DisplayName("소수점 반올림 테스트")
    @Test
    void 소수점_반올림_테스트() {
        // given
        Map<Prize, Long> prizeMap = new EnumMap<>(Prize.class);
        prizeMap.put(Prize.SECOND, 1L);
        long money = 3000000L;
        // when
        PrizeCalculator calculator = new PrizeCalculator(prizeMap, money);
        double prizeRate = calculator.calculatePrizeRate();

        // then
        double expectedRate = 100.0 * Prize.SECOND.getPrize() / money;
        assertThat(Math.round(expectedRate * 10) / 10.0).isEqualTo(expectedRate);
    }

    @DisplayName("오버플로우 발생 테스트")
    @Test
    void 오버플로우_발생_테스트() {
        // given
        Map<Prize, Long> prizeMap = new EnumMap<>(Prize.class);
        prizeMap.put(Prize.FIRST, Long.MAX_VALUE);
        long money = 2L;

        //when & then
        assertThatThrownBy(() -> new PrizeCalculator(prizeMap, money)).isInstanceOf(
                IllegalStateException.class);
    }

}
