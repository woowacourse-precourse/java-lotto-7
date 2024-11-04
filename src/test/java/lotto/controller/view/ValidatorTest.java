package lotto.controller.view;

import java.util.List;
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


    @DisplayName("구분자가 포함되어 있지 않으면 에러를 반환한다.")
    @Test
    void checkDelimiterOrThrow() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1;23;14;24;23;12")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() +
                        policy.getDelimiter()
                        + ExceptionMessage.INPUT_CHECK_DELIMITER.getMessage());
    }
    @DisplayName("구분자가 포함되어 있으면 에러를 반환하지 않는다.")
    @Test
    void checkDelimiterOrThrow2() {
        //given
        //when
        List<Integer> integers = validator.validateWinningNumberInput("1,2,3,4,5,6");
        //then
        Assertions.assertThat(integers.size()).isEqualTo(6);
    }

    @DisplayName("구분자로 나눈 값이 숫자가 아니면 에러 반환")
    @Test
    void validateWinningNumber() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1,w,2,3,4,6")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("1-45사이의 숫자가 아니면 에러 반환")
    @Test
    void validatedWinningNumbers(){
    //given

    //when

    //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1,2,3,4,5,100")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage()+
                        policy.getMinNumberLimit()+ExceptionMessage.RANGE_SYMBOL.getMessage()
                        +policy.getMaxNumberLimit()
                        +ExceptionMessage.INPUT_WINNING_NUMBER_RANGE.getMessage());

    }

    @DisplayName("음수가 포함되었을경우 에러 반환")
    @Test
    void validatedWinningNumbers2(){
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1,2,-3,5,6,100")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage()+
                        policy.getMinNumberLimit()+ExceptionMessage.RANGE_SYMBOL.getMessage()
                        +policy.getMaxNumberLimit()
                        +ExceptionMessage.INPUT_WINNING_NUMBER_RANGE.getMessage());

    }

    @DisplayName("중복된 숫자가 있을경우 에러반환")
    @Test
    void validateDuplicateNumbers(){
    //given

    //when

    //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1,2,3,3,5,6")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage()+
                        ExceptionMessage.INPUT_DUPLICATE_NUMBER.getMessage());
    }
    @DisplayName("당첨숫자가 6개가 아니면 에러반환")
    @Test
    void validateWinningNumberSize(){
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateWinningNumberInput("1,2,3,4,5,6,7")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() +
                        policy.getWinningNumberCount() + ExceptionMessage.INPUT_WINNING_COUNT.getMessage());
    }


    @DisplayName("보너스 번호는 당첨번호와 중복될 수 없다.")
    @Test
    void validateBonusNumberInput(){
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateBonusNumberInput(winningNumbers,"2")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage() +
                        ExceptionMessage.INPUT_BONUS_NOT_IN_WINNING_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호는 당첨범위를 넘을 수 없다.")
    @Test
    void checkNumberRangeOrThrow(){
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when

        //then
        Assertions.assertThatThrownBy(() ->
                        validator.validateBonusNumberInput(winningNumbers,"55")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR.getMessage()+
                        policy.getMinNumberLimit()+ExceptionMessage.RANGE_SYMBOL.getMessage()
                        +policy.getMaxNumberLimit()
                        +ExceptionMessage.INPUT_WINNING_NUMBER_RANGE.getMessage());
    }






}