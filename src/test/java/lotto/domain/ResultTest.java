package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    @ParameterizedTest
    @MethodSource("countsAndReward")
    void Result에_있는_필드들의_개수가_Reward의_기준과_일치하면_참을_반환한다(int hitCount, int bonusCount, Reward reward) {
        Result result = new Result(hitCount, bonusCount);
        assertThat(result.isCountSameAsReward(reward)).isEqualTo(true);
    }

    @Test
    void Result에_있는_필드들의_개수가_Reward의_기준과_다르면_거짓을_반환한다() {
        Result result = new Result(4, 0);
        assertThat(result.isCountSameAsReward(Reward.HIT_6)).isEqualTo(false);
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
