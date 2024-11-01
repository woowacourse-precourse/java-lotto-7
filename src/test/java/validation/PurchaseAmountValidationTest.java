package validation;

import lotto.model.Lotto;
import lotto.validation.PurchaseAmountValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;



public class PurchaseAmountValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","abc"})
    @NullAndEmptySource
    @DisplayName("구매 금액이 null이거나 빈 값, 또는 숫자가 아닐 때 에러 발생")
    void validateNullOrEmpty(String input){
        assertThatThrownBy(() -> {
            PurchaseAmountValidation.validate(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

}
