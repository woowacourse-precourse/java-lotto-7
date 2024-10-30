package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.validate.EmptyInputValidator;
import lotto.view.validate.LottoNumberRangeValidator;
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

    @Test
    @DisplayName("당첨 번호 검증, 각 숫자가 1~45 사이 숫자인지, 숫자 개수 6개인지, 중복되지 않는지, 숫자 형식인지, "
            + "양수인지, 값이 입력되었는지 테스트")
    void validateWinningNumber() {
        String strInput = "1,2,3,4,5,6";
        EmptyInputValidator.validate(strInput);
        List<String> list = new ArrayList<>();
        for (String s : strInput.split(",")) {
            NumberFormatValidator.validate(s);
        }

        Set<Integer> inputWinningNumber = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6));
        InputView.validate6Numbers(inputWinningNumber);
        for (int number : inputWinningNumber) {
            LottoNumberRangeValidator.validate(number);
        }
    }
}