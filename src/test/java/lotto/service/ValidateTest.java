package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateTest {
    Validate validate;
    @BeforeEach
    void setUp () {
        validate = new Validate();
    }

    @Test
    void 로또_구입_성공() {
        // given
        String input = "5000";

        // when
        int result = validate.validatePurchaseAmount(input);

        // then
        assertEquals(5, result);
    }

    @Test
    void 당첨_번호_입력_성공() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<Integer> result = validate.validateWinningNumbers(input);

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void validateBonusNumber() {
        // given
        String input = "1";
        List<Integer> winningNumbers = List.of(2,3,4,5,6,7);

        // when
        int result = validate.validateBonusNumber(input, winningNumbers);

        // then
        assertEquals(1, result);
    }
}