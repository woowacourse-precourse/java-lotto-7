package lotto.lotto.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoValidatorTest {

    private static Stream<List<Integer>> argumentsForCheckNumbersSizeIsNot6ReturnFalse() {
        return Stream.of(
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5, 6, 7, 8)
        );
    }

    private static Stream<List<Integer>> argumentsForCheckNumbersHasDuplicatedNumberReturnFalse() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 5),
                List.of(1, 2, 3, 4, 5, 1),
                List.of(1, 2, 3, 4, 5, 4)
        );
    }

    private static Stream<List<Integer>> argumentsForCheckNumbersHasOutOfRangeNumberReturnFalse() {
        return Stream.of(
                List.of(0, 2, 3, 4, 5, 46),
                List.of(0, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }

    @DisplayName("성공 | 로또 번호의 크기가 6인 경우 참을 반환")
    @Test
    void should_Success_When_CheckNumbersSizeIs6ReturnTrue() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        boolean result = LottoValidator.NUMBERS_SIZE.check(numbers);

        assertTrue(result);
    }

    @DisplayName("성공 | 로또 번호의 크기가 6이 아닌 경우 거짓을 반환")
    @ParameterizedTest
    @MethodSource("argumentsForCheckNumbersSizeIsNot6ReturnFalse")
    void should_Success_When_CheckNumbersSizeIsNot6ReturnFalse(List<Integer> numbers) {
        boolean result = LottoValidator.NUMBERS_SIZE.check(numbers);

        assertFalse(result);
    }

    @DisplayName("성공 | 로또 번호에 중복된 숫자가 없는 경우 참을 반환")
    @Test
    void should_Success_When_CheckNumbersHasNoDuplicatedNumberReturnTrue() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        boolean result = LottoValidator.DUPLICATED.check(numbers);

        assertTrue(result);
    }

    @DisplayName("성공 | 로또 번호에 중복된 숫자가 있는 경우 거짓을 반환")
    @ParameterizedTest
    @MethodSource("argumentsForCheckNumbersHasDuplicatedNumberReturnFalse")
    void should_Success_When_CheckNumbersHasDuplicatedNumberReturnFalse(List<Integer> numbers) {
        boolean result = LottoValidator.DUPLICATED.check(numbers);

        assertFalse(result);
    }

    @DisplayName("성공 | 로또 번호가 1부터 45 사이의 숫자로만 이루어진 경우 참을 반환")
    @Test
    void should_Success_When_CheckNumbersHasNoOutOfRangeNumberReturnTrue() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);

        boolean result = LottoValidator.OUT_OF_RANGE.check(numbers);

        assertTrue(result);
    }

    @DisplayName("성공 | 로또 번호가 1부터 45 사이의 숫자로만 이루어지지 않은 경우 거짓을 반환")
    @ParameterizedTest
    @MethodSource("argumentsForCheckNumbersHasOutOfRangeNumberReturnFalse")
    void should_Success_When_CheckNumbersHasOutOfRangeNumberReturnFalse(List<Integer> numbers) {
        boolean result = LottoValidator.OUT_OF_RANGE.check(numbers);

        assertFalse(result);
    }
}