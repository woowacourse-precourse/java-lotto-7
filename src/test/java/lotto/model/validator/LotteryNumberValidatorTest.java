package lotto.model.validator;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.Exceptions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LotteryNumberValidatorTest {
    @Test
    @DisplayName("[success] 6개의 1 이상 45 이하의 6개의 숫자 리스트를 검증한다.")
    void inputNormalInteger() {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        assertThatCode(() -> LotteryNumberValidator.validate(testNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("[로또번호 / 당첨번호 공통 예외 1] 숫자의 사이즈가 6이 아니면 예외가 발생한다.")
    @MethodSource("wrongSizeNumbersProvider")
    void fail_IfNumbersSizeNotSix(List<Integer> numbers) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                        () -> LotteryNumberValidator.validate(numbers))
                .withMessage(Exceptions.WRONG_LOTTERY_NUMBER_SIZE.getMessage());
    }

    static Stream<List<Integer>> wrongSizeNumbersProvider() {
        return Stream.of(
                new ArrayList<>(List.of(1, 2, 3, 4, 5)),
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @DisplayName("[로또번호 / 당첨번호 공통 예외 2] 중복된 숫자가 있을 경우 예외가 발생한다.")
    @MethodSource("duplicatedNumbersProvider")
    void fail_IfDuplicatedNumbersExist(List<Integer> numbers) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                        () -> LotteryNumberValidator.validate(numbers))
                .withMessage(Exceptions.DUPLICATED_LOTTERY_NUMBER.getMessage());
    }

    static Stream<List<Integer>> duplicatedNumbersProvider() {
        return Stream.of(
                new ArrayList<>(List.of(1, 1, 3, 4, 5, 6)),
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 1))
        );
    }

    @ParameterizedTest
    @DisplayName("[로또번호 / 당첨번호 공통 예외 3] 숫자가 로또 숫자의 범위를 벗어난 경우 예외가 발생한다.")
    @ValueSource(ints = {46, -1, 0, 100, -100})
    void fail_IfOutOfRangeNumberExists(int wrongNumber) {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, wrongNumber));
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                        () -> LotteryNumberValidator.validate(testNumbers))
                .withMessage(Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
    }
}
