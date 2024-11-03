package lotto.constant;


import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTierTest {

    @DisplayName("Test checking Prize Tier")
    @ParameterizedTest()
    @MethodSource("verifyPrizeTier")
    void shouldReturnMatchedTier(int matchCount, boolean isBonusNumberMatched, PrizeTier result){

        PrizeTier tier = PrizeTier.checkPrizeTier(matchCount,isBonusNumberMatched);

        assertThat(tier.name()).isEqualTo(result.name());

    }

    static Stream<Arguments> verifyPrizeTier() {
        return Stream.of(
                Arguments.of(6,false,PrizeTier.FIRST),
                Arguments.of(5,true,PrizeTier.SECOND),
                Arguments.of(5,false,PrizeTier.THIRD),
                Arguments.of(4,false,PrizeTier.FORTH),
                Arguments.of(4,true,PrizeTier.FORTH),
                Arguments.of(3,false,PrizeTier.FIFTH),
                Arguments.of(3,true,PrizeTier.FIFTH),
                Arguments.of(2,false,PrizeTier.NONE),
                Arguments.of(2,true,PrizeTier.NONE)
        );
    }
}
