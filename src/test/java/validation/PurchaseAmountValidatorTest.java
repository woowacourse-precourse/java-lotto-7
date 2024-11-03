package validation;

import lotto.validation.PurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","abc"})
    @NullAndEmptySource
    @DisplayName("구매 금액이 null이거나 빈 값, 또는 숫자가 아닐 때 에러 발생")
    void validateNullOrEmptyTest(String input){
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.parseValidatedTicketCount(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"0"," 0 ","123"})
    @DisplayName("구매 금액이 0이거나 빈 값, 또는 숫자가 아닐 때 에러 발생")
    void validateZeroOrNotDividedTest(String input){
        assertThatThrownBy(() -> {
            PurchaseAmountValidator.parseValidatedTicketCount(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
