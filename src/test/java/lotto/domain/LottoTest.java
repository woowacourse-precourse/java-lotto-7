package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    static final List<Integer> MORE_THAN_SIX_SIZE_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7);
    static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    static final List<Integer> MORE_THAN_FIFTY_FIVE_NUMBERS = List.of(1, 2, 3, 4, 5, 67);

    @DisplayName("""
                "로또 번호의 개수가 6개가 넘어가면 예외가 발생한다"
                "로또 번호에 중복된 숫자가 있으면 예외가 발생한다."
                "로또 번호 숫자가 45가 넘으면 예외가 발생한다."
            """)
    @ParameterizedTest
    @MethodSource("provideFewConditionedList")
    void lottoNumberConditionsTest(List<Integer> input, IllegalArgumentException expected) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(expected.getClass())
                .hasMessage(expected.getMessage());
    }

    private static Stream<Arguments> provideFewConditionedList() {
        return Stream.of(
                Arguments.of(MORE_THAN_SIX_SIZE_NUMBERS,
                        new IllegalArgumentException(ErrorMessage.NUMBER_SIZE_ERROR.getMessage())),
                Arguments.of(DUPLICATE_NUMBERS,
                        new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getMessage())),
                Arguments.of(MORE_THAN_FIFTY_FIVE_NUMBERS,
                        new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR.getMessage()))
        );
    }
}

