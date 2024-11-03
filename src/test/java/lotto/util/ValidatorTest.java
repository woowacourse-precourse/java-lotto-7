package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    void 입력이_비어있으면_예외_발생() {
        String input = "";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyInput(input);
        }, "입력이 비어있으면 예외 발생");
    }

    @Test
    void 입력이_null이면_예외_발생() {
        String input = null;

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateEmptyInput(input);
        }, "입력이 null이면 예외 발생");
    }

    @Test
    void 정수가_아닐_경우_예외_발생() {
        String input = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNumber(input);
        }, "정수가 아닐 경우 예외 발생");
    }

    @Test
    void int범위를_벗어난_경우_예외_발생() {
        String input = String.valueOf(Long.MAX_VALUE);;

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNonNumber(input);
        }, "int 범위를 벗어난 경우 예외 발생");
    }

    @Test
    void 양수가_아닐_경우_예외_발생() {
        String input = "-1";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validatePositiveNumber(input);
        }, "양수가 아닐 경우 예외 발생");
    }

    @Test
    void 천_단위가_아닐_경우_예외_발생() {
        String input = "1500";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateDivisibleByThousand(input);
        }, "1000 단위가 아닐 경우 예외 발생");
    }

    @Test
    void 로또_번호_범위가_아닌_경우_예외_발생() {
        String input = "100";

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateNumberRange(input);
        }, "로또 번호 범위(1~45)가 아닌 경우 예외 발생");
    }

    @Test
    void 보너스번호가_당첨번호에_포함되면_예외_발생() {
        String input = "1";
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validateWinningNumbersContainBonus(input, winningNumbers);
        }, "보너스 번호가 당첨 번호에 포함되면 예외 발생");
    }
}