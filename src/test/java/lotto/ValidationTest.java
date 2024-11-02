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
}