package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {
    @Test
    public void 금액_유효성_실패_테스트(){
        String[] invalidPrices = {
                "price1000",
                "1000$@#^",
                null,
                "",
                " "
        };

        for (String price : invalidPrices)
            Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.validatePrice(price));
    }

    @Test
    public void 금액_유효성_성공_테스트(){
        String validPrice = "1000";
        Assertions.assertDoesNotThrow(() -> Validation.validatePrice(validPrice));
    }

    @Test
    public void 당첨_번호_유효성_테스트(){
        String[][] invalidNumbers = {
                {"1"},
                {},
                null,
                {"t","2","h","^"},
                {"1 ", "2", "3", "4", "5", "6"},
                {"1", "2", "100", "4", "5", "6"}
        };
        for (String[] numbers : invalidNumbers)
            Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.validateWinningNumbers(numbers));

        String[] validNumbers = {"1", "2", "3", "4", "5", "6"};
        Assertions.assertDoesNotThrow(() -> Validation.validateWinningNumbers(validNumbers));
    }

    @Test
    public void 보너스_번호_유효성_테스트(){
        String[] invalidBonusNumbers= {
                "ㄷ",
                "^",
                null,
                "",
                " ",
                "100"
        };

        for (String bonusNumber : invalidBonusNumbers)
            Assertions.assertThrows(IllegalArgumentException.class, () -> Validation.validateBonusNumbers(bonusNumber));

        String validBonusNumbers = "7";
        Assertions.assertDoesNotThrow(() -> Validation.validateBonusNumbers(validBonusNumbers));
    }
}