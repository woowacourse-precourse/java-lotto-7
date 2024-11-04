package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateExceptionTest {
    Validate validate;
    @BeforeEach
    void setUp () {
        validate = new Validate();
    }

    @Test
    void 로또_구입_실패_숫자가_아닌_입력() {
        // given
        String input = "a";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validatePurchaseAmount(input));
    }
    @Test
    void 로또_구입_실패_1000원_단위가_아닌_입력() {
        // given
        String input = "5001";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validatePurchaseAmount(input));
    }
    @Test
    void 로또_구입_실패_1000원_미만_입력() {
        // given
        String input = "500";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validatePurchaseAmount(input));
    }

    @Test
    void 당첨_번호_입력_실패_숫자_아님() {
        // given
        String input = "a,b,c,d,e, ";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }
    @Test
    void 당첨_번호_입력_실패_6개_미만() {
        // given
        String input = "1,2,3,4,5";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }
    @Test
    void 당첨_번호_입력_실패_6개_초과() {
        // given
        String input = "1,2,3,4,5,6,7";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }
    @Test
    void 당첨_번호_입력_실패_번호_1미만() {
        // given
        String input = "1,2,3,4,5,-6";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }
    @Test
    void 당첨_번호_입력_실패_번호_45초과() {
        // given
        String input = "1,2,3,4,5,46";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }
    @Test
    void 당첨_번호_입력_실패_중복() {
        // given
        String input = "1,2,3,4,5,5";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateWinningNumbers(input));
    }

    @Test
    void 보너스_번호_입력_실패_숫자_아님() {
        // given
        String input = "a";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateBonusNumber(input, winningNumbers));
    }
    @Test
    void 보너스_번호_입력_실패_번호_1미만() {
        // given
        String input = "-1";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateBonusNumber(input, winningNumbers));
    }
    @Test
    void 보너스_번호_입력_실패_번호_45초과() {
        // given
        String input = "46";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> validate.validateBonusNumber(input, winningNumbers));
    }
}
