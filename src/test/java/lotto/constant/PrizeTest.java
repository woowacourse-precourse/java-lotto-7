package lotto.constant;

import static lotto.constant.Prize.FIFTH;
import static lotto.constant.Prize.FIRST;
import static lotto.constant.Prize.FOURTH;
import static lotto.constant.Prize.SECOND;
import static lotto.constant.Prize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("== Prize 테스트 ==")
public class PrizeTest {
    @ParameterizedTest
    @DisplayName("조건에 해당하는 당첨 가져오기")
    @MethodSource("getPrizeArguments")
    void 당첨_가져오기(final int matchedLottoNumberCount, final boolean matchedBonus, Prize prize) {
        assertThat(Prize.getPrize(matchedLottoNumberCount, matchedBonus))
                .isEqualTo(prize);
    }

    static Stream<Arguments> getPrizeArguments() {
        return Stream.of(
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, false, FOURTH),
                Arguments.of(4, true, FOURTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(2, true, null),
                Arguments.of(1, false, null)
        );
    }
}
