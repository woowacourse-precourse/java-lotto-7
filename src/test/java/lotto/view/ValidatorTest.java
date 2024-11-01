package lotto.view;

import lotto.controller.LottoPolicy;
import lotto.controller.Policy;
import lotto.controller.view.Validator;
import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    public Validator validator;
    public Policy policy;

    @BeforeEach
    void init() {
        policy = new LottoPolicy();
        validator = Validator.newInstance(policy);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 에러를 반환한다.")
    @Test
    void validatePurchasedAmount() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateAmountInput("13002")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() +
                        ExceptionMessage.AMOUNT.getMessage() + policy.getAmountPolicy()
                        + ExceptionMessage.AMOUNT_UNIT.getMessage());
    }

    @DisplayName("구입 금액이 1000원 단위면 통과한다.")
    @Test
    void validatePurchasedAmount2() {
        //given
        //when
        validator.validateAmountInput("13000");
        //then
    }

    @DisplayName("input값이 숫자가 아니면 에러를 반환한다.")
    @Test
    void validateNumber() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateAmountInput("ㅇㅈㄴㅇㅁ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_NUMBER_EXCEPTION.getMessage());

    }

    @DisplayName("input값이 숫자면 에러를 반환하지 않는다.")
    @Test
    void validateNumber2() {
        //given
        //when
        validator.validateAmountInput("123000");
        //then
    }

    @DisplayName("input값이 음수면 에러를 반환한다.")
    @Test
    void validatePositive() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateAmountInput("-4")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_NUMBER_POSITIVE.getMessage());
    }
    @DisplayName("input값이 0이면 에러를 반환한다.")
    @Test
    void validateMinAmount() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateAmountInput("0")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_AMOUNT_MIN.getMessage());
    }

}