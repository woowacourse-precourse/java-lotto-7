package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("보너스 번호 검증, 숫자가 1~45 사이 숫자인지, 숫자 형식인지, 양수인지, 숫자 개수 1개인지,"
            + " 값이 입력되었는지 테스트")
    void validateBonusNumber() {
        String strInput = "1";
        EmptyInputValidator.validate(strInput);
        NumberFormatValidator.validate(strInput);
        InputView.validate1Numbers(strInput);

        int intInput = Integer.parseInt(strInput);
        PositiveNumberValidator.validate(intInput);
        LottoNumberRangeValidator.validate(intInput);

        assertThat(intInput).isEqualTo(1);
    }

    @Test
    @DisplayName("빈 값 예외 처리 테스트")
    void validateEmptyInput() {
        String Input = "";
        assertThatThrownBy(() -> {
            EmptyInputValidator.validate(Input);
        })
                .hasMessageContaining("[ERROR] 입력값이 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "test", "안녕하세요"})
    @DisplayName("숫자 형식이 아닌 값 예외 처리 테스트")
    void validateNumberFormat(String input) {
        assertThatThrownBy(() -> {
            NumberFormatValidator.validate(input);
        })
                .hasMessageContaining("[ERROR] 입력 값은 숫자 형식이어야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10, -1000, -28439})
    @DisplayName("음수인 값 예외 처리 테스트")
    void validatePositiveNumber(int input) {
        assertThatThrownBy(() -> {
            PositiveNumberValidator.validate(input);
        })
                .hasMessageContaining("[ERROR] 입력 값은 양수여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 49378, 2500, 13938713})
    @DisplayName("로또 구입 금액 단위 예외 테스트")
    void validatePurchaseAmountException(int input) {
        assertThatThrownBy(() -> {
            InputView.validatePurchaseAmount(input);
        })
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}