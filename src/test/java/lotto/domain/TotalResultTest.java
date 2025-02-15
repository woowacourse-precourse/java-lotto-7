package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import org.junit.jupiter.api.Test;

public class TotalResultTest {

    @Test
    void 객체_내부_있는_컬렉션을_참조하여_당첨_금액의_합산_내역을_반환한다() {
        TotalResult totalResult = new TotalResult(generateMockEnumMap());
        assertThat(totalResult.calcSumOfPrize()).isEqualTo(2031555000L);
    }

    private EnumMap<Reward, Integer> generateMockEnumMap() {
        EnumMap<Reward, Integer> totalResult = new EnumMap<>(Reward.class);
        Arrays.stream(Reward.values()).forEach(reward -> totalResult.put(reward, 1));

        return totalResult;
    }
}
