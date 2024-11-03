package lotto.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import lotto.error.ErrorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ListValidatorTest {

    private ListValidator listValidator;
    private NumberValidator numberValidator;

    @BeforeEach
    void setUp() {
        listValidator = ListValidator.getInstance();
        numberValidator = NumberValidator.getInstance();
    }

    @DisplayName("리스트 사이즈가 요구 사이즈와 맞지 않아 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("exceededSizeList")
    void validateSizeTest(final List<Integer> numbers) {
        //given
        final int size = 6;
        //should
        assertThatIllegalArgumentException().isThrownBy(() -> listValidator.validateSize(numbers, size))
                .withMessageContaining(ErrorType.INVALID_WINNING_NUMBER_SIZE);
    }

    static Stream<List<Integer>> exceededSizeList() {
        return Stream.of(
                Collections.EMPTY_LIST,
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1)
        );
    }

    @DisplayName("리스트에 중복된 요소가 존재하여 예외가 발생한다.")
    @Test
    void validateDuplicateTest() {
        //given
        final List<Integer> numbers = List.of(1, 1, 1);
        //should
        assertThatIllegalArgumentException().isThrownBy(() -> listValidator.validateDuplicate(numbers))
                .withMessageContaining(ErrorType.DUPLICATED_WINNING_NUMBERS);
    }

    @DisplayName("리스트에 범위를 벗어나는 요소가 존재하여 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeList")
    void validateRangeTest(final List<Integer> numbers) {
        //given
        final int min = 3;
        final int max = 10;
        //should
        assertThatIllegalArgumentException().isThrownBy(
                        () -> listValidator.validateRange(numbers, number -> numberValidator.validateRange(number, min, max)))
                .withMessageContaining(ErrorType.EXCEEDED_NUMBER_RANGE);
    }

    static Stream<List<Integer>> outOfRangeList() {
        return Stream.of(
                List.of(1, 4, 5),
                List.of(3, 4, 11)
        );
    }
}
