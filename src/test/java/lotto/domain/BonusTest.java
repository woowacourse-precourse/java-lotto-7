package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusTest {
    static final int SIX = 6;
    static final List<Integer> LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 10);
    static final Map<Integer, List<Integer>> DUPLICATE_WITH_LOTTO_MAP = Map.of(6, List.of(1, 2, 3, 4, 5, 6));
    static final Map<Integer, List<Integer>> OVER_FOTIY_FIVE_MAP = Map.of(67, List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호 생성 테스트")
    @Test
    void createBonus() {
        //given, when
        Bonus result = new Bonus(SIX, LOTTO_NUMBERS);
        //then
        assertThat(result.getNumber()).isEqualTo(SIX);
    }

    @DisplayName("""
            보너스 번호가 로또번호와 중복된 숫자가 있으면 예외가 발생한다.
            보너스 번호 숫자가 45가 넘으면 예외가 발생한다.
            """)
    @ParameterizedTest
    @MethodSource("provideFewErrorCase")
    void bonusNumberConditionTest(Map<Integer, List<Integer>> input, IllegalArgumentException expected) {
        //given
        int bonusNumber = input.keySet().iterator().next();
        List<Integer> lottoNumbers = input.get(bonusNumber);
        //when, then
        assertThatThrownBy(() -> new Bonus(bonusNumber, lottoNumbers))
                .isInstanceOf(expected.getClass())
                .hasMessageContaining(expected.getMessage());
    }

    private static Stream<Arguments> provideFewErrorCase() {
        return Stream.of(
                Arguments.of(DUPLICATE_WITH_LOTTO_MAP,
                        new IllegalArgumentException(ErrorMessage.SAME_WITH_LOTTO_NUMBER_ERROR.getMessage())
                ),
                Arguments.of(OVER_FOTIY_FIVE_MAP,
                        new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR.getMessage())
                )
        );
    }

}