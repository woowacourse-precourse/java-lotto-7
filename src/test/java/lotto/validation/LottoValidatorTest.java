package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoValidatorTest {
    @Test
    void 금액으로_음수_값이_오면_예외가_발생한다() {
        int input = -1000;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.checkValidCashAmount(input));
    }

    @Test
    void 금액으로_천_단위_입력이_아니면_예외가_발생한다() {
        int input = 1001;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.checkValidCashAmount(input));
    }

    @Test
    void 로또_숫자_입력이_6개가_아니면_예외가_발생한다() {
        List<Integer> underSixLengthInput = List.of(1,2,3,4,5);
        List<Integer> overSixLengthInput = List.of(1,2,3,4,5,6,7);
        Assertions.assertAll(
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> LottoValidator.checkLottoSize(underSixLengthInput)),
                () -> Assertions.assertThrows(IllegalArgumentException.class,
                        () -> LottoValidator.checkLottoSize(overSixLengthInput))
        );
    }

    @Test
    void 로또_숫자_입력이_1과_45사이를_벗어나면_예외가_발생한다() {
        List<Integer> inputs = List.of(0,50);
        Assertions.assertAll(
                inputs.stream()
                        .map(input -> () -> Assertions.assertThrows(IllegalArgumentException.class,
                                () -> LottoValidator.checkNumberInRange(input)))
        );
    }
}
