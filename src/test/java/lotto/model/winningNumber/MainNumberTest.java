package lotto.model.winningNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.Exceptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MainNumberTest {
    @Test
    @DisplayName("[success] 당첨번호 6개를 리스트에 저장한다.")
    void saveMainNumberList() {
        List<Integer> testNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        MainNumber mainNumber = new MainNumber(testNumbers);

        for (int number : testNumbers) {
            assertThat(mainNumber.numbers()).contains(number);
        }
    }

    @ParameterizedTest
    @DisplayName("[fail] 당첨번호가 6개가 아니면 예외가 발생한다.")
    @MethodSource("wrongMainNumberSizeProvider")
    void fail_IfMainNumberSizeNotSix(List<Integer> testNumbers) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new MainNumber(testNumbers))
                .withMessage(Exceptions.WRONG_LOTTERY_NUMBER_SIZE.getMessage());
    }

    static Stream<List<Integer>> wrongMainNumberSizeProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @DisplayName("[fail] 당첨번호에 1 이상 45 이하가 아닌 숫자가 있으면 예외가 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    void fail_IfNotInRangeMainNumberExists(int wrongNumber) {
        List<Integer> numbersIncludingInvalidRange = new ArrayList<>(Arrays.asList(wrongNumber, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new MainNumber(numbersIncludingInvalidRange))
                .withMessage(Exceptions.OUT_OF_LOTTERY_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("[fail] 당첨번호 중 중복되는 번호가 있으면 예외가 발생한다.")
    void fail_IfDuplicatedMainNumberExists() {
        List<Integer> numbersIncludingDuplication = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new MainNumber(numbersIncludingDuplication))
                .withMessage(Exceptions.DUPLICATED_LOTTERY_NUMBER.getMessage());
    }

    @Test
    @DisplayName("[fail] getter로 받은 당첨번호 리스트를 수정하는 경우 예외가 발생한다.")
    void fail_IfModifyMainNumberList() {
        MainNumber mainNumber = new MainNumber(
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> mainNumberList = mainNumber.numbers();

        assertThatThrownBy(() -> mainNumberList.add(7))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> mainNumberList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
