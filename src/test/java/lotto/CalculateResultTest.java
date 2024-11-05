package lotto;

import java.util.HashMap;
import lotto.item.Money;
import lotto.model.CalculateResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateResultTest {
    @Test
    @DisplayName("정상적인 값 입력(당첨값 없을 때)")
    void 정상값테스트_당첨없음() {
        HashMap<Integer, Integer> mapforTest = new HashMap<>();
        mapforTest.put(5000, 0);
        mapforTest.put(50000, 0);
        mapforTest.put(1500000, 0);
        mapforTest.put(30000000, 0);
        mapforTest.put(2000000000, 0);
        assertThat(new CalculateResult().Calculate(mapforTest, new Money("10000")))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("정상적인 값 입력(당첨됨)")
    void 정상값테스트_당첨됨() {
        HashMap<Integer, Integer> mapforTest = new HashMap<>();
        mapforTest.put(5000, 1);
        mapforTest.put(50000, 1);
        mapforTest.put(1500000, 1);
        mapforTest.put(30000000, 1);
        mapforTest.put(2000000000, 1);
        assertThat(new CalculateResult().Calculate(mapforTest, new Money("10000")))
                .isEqualTo(203155.5f);
    }
}
