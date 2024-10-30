package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.view.validate.EmptyInputValidator;
import lotto.view.validate.NumberFormatValidator;
import lotto.view.validate.PositiveNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Test
    @DisplayName("구입 금액 1000원으로 나누어 떨어지는지, 숫자 형식인지, 양수인지, 값이 입력되었는지 테스트")
    void validatePurchaseAmount() {
        String strInput = "1000";
        EmptyInputValidator.validate(strInput);
        NumberFormatValidator.validate(strInput);

        int intInput = Integer.parseInt(strInput);
        PositiveNumberValidator.validate(intInput);
        InputView.validatePurchaseAmount(intInput);

        assertThat(intInput).isEqualTo(1000);
    }
    
}