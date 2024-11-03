package lotto.validator.strategy;

import lotto.util.converter.PurchaseCountConverter;
import lotto.validator.InputValidator;
import lotto.validator.factory.InputValidatorStrategyFactory;
import lotto.validator.type.InputType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.validator.type.InputType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayName("[유닛 테스트] - 구입 금액 형식 검증")
class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"lotto", "amount1000", " 1000", "-1000"})
    @DisplayName("구입 금액 형식 검증 - 정수가 아닌 문자열 변환 시도 시 예외 발생")
    void nonPositiveString_validate_throwException(String inputPurchaseAmount) {
        //given
        InputValidatorStrategyFactory inputValidatorStrategyFactory = new InputValidatorStrategyFactory();
        InputValidator inputValidator = inputValidatorStrategyFactory.getValidator(PURCHASE_AMOUNT);

        //when
        Throwable throwable = catchThrowable(() -> inputValidator.validate(inputPurchaseAmount));

        //then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        assertThat(throwable).hasMessage("[ERROR] 구매 금액은 양수만 입력 가능합니다.");
    }
}