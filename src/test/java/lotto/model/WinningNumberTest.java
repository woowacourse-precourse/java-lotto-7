package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.winningNumber.WinningNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {
    @ParameterizedTest
    @MethodSource("invalidLottoNumbersAmountProvider")
    void 당첨번호가_6개가_아니면_예외(List<Integer> testNumbers) {
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(testNumbers))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }
    static Stream<List<Integer>> invalidLottoNumbersAmountProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 당첨번호가_1이상_45이하가_아니면_예외(int testNumber) {
        List<Integer> numbersIncludingInvalidRange = new ArrayList<>(Arrays.asList(testNumber, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(numbersIncludingInvalidRange))
                .withMessage("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
    }

    @Test
    void 당첨번호가_중복되면_예외() {
        List<Integer> numbersIncludingDuplication = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(
                        () -> new WinningNumber(numbersIncludingDuplication))
                .withMessage("[ERROR] 중복되지 않은 숫자를 입력해주세요.");
    }
}
