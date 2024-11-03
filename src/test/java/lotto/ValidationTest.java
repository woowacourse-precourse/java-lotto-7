package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.utils.Validator;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void 구입_금액_유효성_테스트() {
        String[] invalidInputs = {"0", "3333", "-1000", "java", " "};

        for (String input : invalidInputs){
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validatePurchaseInput(input);
            });
        }

        assertDoesNotThrow(() -> {
            Validator.validatePurchaseInput("8000");
        });
    }

    @Test
    void 당첨_번호_유효성_테스트() {
        String[] invalidInputs = {
            "1,2,3,4,5,6,7",
            "1,2,3,4",
            "a,b,c,d,e,f",
            "1,2,3,4,5,46",
            "1,2,3,4,5,5"
        };

        for (String input : invalidInputs) {
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateWinningNumbersInput(input);
            });
        }

        assertDoesNotThrow(() -> {
            Validator.validateWinningNumbersInput("1,2,3,4,5,45");
        });
    }

    @Test
    void 보너스_번호_유효성_테스트() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        String[] invalidInputs = {"a", "100", "6"};

        for (String input : invalidInputs) {
            assertThrows(IllegalArgumentException.class, () -> {
                Validator.validateBonusNumberInput(input, winningNumbers);
            });
        }

        assertDoesNotThrow(() -> {
            Validator.validateBonusNumberInput("7", winningNumbers);
        });
    }

}
