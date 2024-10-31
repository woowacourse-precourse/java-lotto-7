package lotto.buyer.validator;
import lotto.buyer.infrastructure.Won;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ValidatorTest {
    @Test
    @DisplayName("1000원으로 안나눠지는 경우 예외 발생")
    void divisibleByThousand() {
        List<String> moneyInfo = List.of("12313","1323","1001","10", "1");
        moneyInfo.forEach((money) -> verifyExceptionForValidation(money, ErrorMessage.DIVISIBLE_BY_THOUSAND));
    }
    @Test
    @DisplayName("10만원 초과일 경우 예외 발생")
    void validateAmountUnderLimit() {
        List<String> amountLimit = List.of("12313123","213213","100001", "123132123");
        amountLimit.forEach((amount) -> verifyExceptionForValidation(amount, ErrorMessage.AMOUNT_LIMIT));
    }
    private void verifyExceptionForValidation(String input, ErrorMessage errorMessage) {
        assertThatThrownBy(
                () -> Won.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }

}
