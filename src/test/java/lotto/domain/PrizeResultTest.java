package lotto.domain;

import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PrizeResultTest {
    @DisplayName("winPrize 메서드를 통해 당첨 개수를 증가시킬 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void 당첨_개수_증가_테스트(int expected) {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.winPrize(Prize.FIRST);
        EnumMap<Prize, Integer> map = prizeResult.getPrizeResult();
        int currentPrizeCount = map.getOrDefault(Prize.FIRST, 0);
        assertThat(currentPrizeCount).isEqualTo(expected);
    }
}
