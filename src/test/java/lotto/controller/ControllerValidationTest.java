package lotto.controller;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_POSITIVE_INTEGER_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ControllerValidationTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1, a, 0"})
    @DisplayName("구매 금액 형식이 양의 정수가 아닐 때 에러 발생")
    void 구매_금액_양의_정수_아니면_에러_발생(final String inputPurchaseMoney) {
        assertThatThrownBy(() -> ControllerValidation.inputPurchaseMoneyValidation(inputPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1, a, 0"})
    @DisplayName("보너스 숫자 형식이 자연수 아닐 때 에러 발생")
    void 보너스_숫자_형식_자연수_아니면_에러_발생(final String inputBonusNumber) {
        assertThatThrownBy(() -> ControllerValidation.inputBonusNumberValidation(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_POSITIVE_INTEGER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 숫자가 당첨 번호와 중복될 때 에러 발생")
    void 보너스_숫자_당첨_번호_중복_에러_발생() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Integer number = 1;

        //expected
        assertThatThrownBy(() -> ControllerValidation.checkAlreadyExistNumber(numbers, number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_WITH_WINNING_ERROR_MESSAGE);
    }
}