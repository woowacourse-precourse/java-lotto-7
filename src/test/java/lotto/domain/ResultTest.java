package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    @ParameterizedTest
    @MethodSource("countsAndReward")
    void Result에_있는_필드들의_개수가_Reward의_기준과_일치하면_해당_항목이_증가한다(int hitCount, int bonusCount, Reward reward) {
        EnumMap<Reward, Integer> totalResult = generateMockEnumMap();
        Result result = new Result(hitCount, bonusCount);
        result.compareResultToCriterion(totalResult, reward);

        assertThat(totalResult.get(reward)).isEqualTo(1);
    }

    private EnumMap<Reward, Integer> generateMockEnumMap() {
        EnumMap<Reward, Integer> totalResult = new EnumMap<>(Reward.class);
        Arrays.stream(Reward.values()).forEach(reward -> totalResult.put(reward, 0));

        return totalResult;
    }

    static Stream<Arguments> countsAndReward() {
        return Stream.of(
                Arguments.of(6, 0, Reward.HIT_6),
                Arguments.of(5, 1, Reward.HIT_5_AND_BONUS),
                Arguments.of(5, 0, Reward.HIT_5),
                Arguments.of(4, 0, Reward.HIT_4),
                Arguments.of(3, 0, Reward.HIT_3)
        );
    }
}
